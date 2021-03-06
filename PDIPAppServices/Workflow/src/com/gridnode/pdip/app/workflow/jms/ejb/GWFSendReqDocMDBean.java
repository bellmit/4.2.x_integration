/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * May 28 2002    Mahesh              Created
 * Oct 20 2005    Neo Sok Lay         Throws clause of ejbCreate method must 
 *                                    not define any application exceptions.
 * Oct 11 2005    Neo Sok Lay         Change for J2EE compliance
 * May 30 2007    Neo Sok Lay         GNDB00028368: Use concurrent locking instead of method synchronization. 
 * Dec 05, 2007   Tam Wei Xiang       To add in the checking of the redelivered jms msg.
 * Jul 27, 2008   Tam Wei Xiang       #69:1) Remove explicitly checked for redeliverd msg and dropped that msg.
 *                                        2) Rollback the entire transaction if encounter retryable exception.
 */
package com.gridnode.pdip.app.workflow.jms.ejb;

import java.util.*;

import javax.ejb.*;
import javax.jms.*;

import com.gridnode.pdip.app.workflow.adaptors.*;
import com.gridnode.pdip.app.workflow.exceptions.ILogErrorCodes;
import com.gridnode.pdip.app.workflow.impl.bpss.helpers.*;
import com.gridnode.pdip.app.workflow.runtime.model.*;
import com.gridnode.pdip.app.workflow.util.*;
import com.gridnode.pdip.base.contextdata.entities.model.*;
import com.gridnode.pdip.app.workflow.util.Logger;
import com.gridnode.pdip.framework.jms.JMSRedeliveredHandler;
import com.gridnode.pdip.framework.util.*;

public class GWFSendReqDocMDBean implements MessageDrivenBean,MessageListener {
 
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7985358745295613656L;
		private MessageDrivenContext m_context;

    public void ejbRemove() {
    }

    /**
     * Sets the session context.
     *
     * @param ctx       MessageDrivenContext Context for session
     */
    public void setMessageDrivenContext(MessageDrivenContext ctx) {
        m_context = ctx;
    }

    public void ejbCreate() {
    }

    // Implementation of MessageListener
    public void onMessage(Message msg) {
        Logger.debug("[GWFSendReqDocMDBean.onMessage] msg="+msg);
        
        String jmsMessageID = "";
        try {
        	
            if(msg.getJMSRedelivered())
            {
              Logger.log("[GWFSendReqDocMDBean.onMessage] Redelivered msg found. Message: "+msg);
            }
            
            jmsMessageID = msg.getJMSMessageID();
            ObjectMessage objMsg = (ObjectMessage) msg;
            Map mapMsg=(Map)objMsg.getObject();

            String documentId=(String)mapMsg.get(IBpssConstants.DOCUMENTID);
            String documentType=(String)mapMsg.get(IBpssConstants.DOCUMENT_TYPE);
            Integer retryCount=(Integer)mapMsg.get(IBpssConstants.RETRY_COUNT);
            String partnerKey=(String)mapMsg.get(IBpssConstants.PARTNER_KEY);
            Long rtProcessDocUId=(Long)mapMsg.get(IBpssConstants.RTPROCESSDOC_UID);
            Long contextUId=(Long)mapMsg.get("contextUId");
            Object documentObject=WorkflowUtil.getDataManager().getContextData(contextUId,new ContextKey(documentType));
            sendReqDocument(documentId,documentType,documentObject,retryCount,partnerKey,rtProcessDocUId,contextUId);
            
        } catch (JMSException e) {
            Logger.error(ILogErrorCodes.WORKFLOW_MDB_ONMESSAGE,
                         "[GWFSendReqDocMDBean.onMessage] JMSException",e);
        } catch (Throwable th) {
        	
            if (JMSRedeliveredHandler.isRedeliverableException(th)) //#69 25072008 TWX
            {
            	Logger.warn("[GWFSendReqDocMDBean.onMessage] encounter JMSException, rolling back all transaction. JMSMessageID:"+jmsMessageID);
          		m_context.setRollbackOnly();
            }
            Logger.error(ILogErrorCodes.WORKFLOW_MDB_ONMESSAGE,
                         "[GWFSendReqDocMDBean.onMessage] Exception "+th.getLocalizedMessage(),th);
        }
    }

    public void sendReqDocument(String documentId,String documentType,Object documentObject,Integer retryCount,String partnerKey,Long rtProcessDocUId,Long contextUId) throws Throwable {
        try{
            Properties prop=WorkflowUtil.getProperties(IWorkflowConstants.CONFIG_WORKFLOW_SENDREQUESTDOC_APP);
            if(retryCount!=null)
                retryCount=new Integer(retryCount.intValue()+1);
            HashMap dataMap=new HashMap();
            dataMap.put(IBpssConstants.DOCUMENT_OBJECT,documentObject);
            dataMap.put(IBpssConstants.DOCUMENTID,documentId);
            dataMap.put(IBpssConstants.DOCUMENT_TYPE,documentType);
            dataMap.put(IBpssConstants.RETRY_COUNT,retryCount);
            dataMap.put(IBpssConstants.PARTNER_KEY,partnerKey);
            dataMap.put("contextUId",contextUId);
            Object obj=AppAdaptor.callApp(prop,dataMap,null);
            
            //NSL20070530
            BpssBusinessTransHelper.acquireRequestRoleLock();
            try
            {
              if(obj!=null){
                  BpssBusinessTransHelper.abort(rtProcessDocUId,GWFRtProcess.CLOSED_ABNORMALCOMPLETED_ABORTED,IBpssConstants.EXCEPTION_TIMETO_ACK,obj,documentType,null);
              } else {
                  GWFRtProcessDoc rtProcessDoc= (GWFRtProcessDoc)UtilEntity.getEntityByKey(rtProcessDocUId,GWFRtProcessDoc.ENTITY_NAME,true);
                  rtProcessDoc.setRetryCount(retryCount);
                  UtilEntity.update(rtProcessDoc,true);
              }
            }
            finally
            {
              BpssBusinessTransHelper.releaseRequestRoleLock();
            }
        }catch(Throwable th){
            Logger.warn("[GWFSendReqDocMDBean.sendReqDocument] Unable to send request document ",th);
            throw th;
        }
    }

}
