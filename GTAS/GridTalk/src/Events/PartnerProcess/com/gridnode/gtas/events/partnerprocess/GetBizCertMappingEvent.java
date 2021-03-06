/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GetBizCertMappingEvent.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Jan 10 2003    Neo Sok Lay         Created
 */
package com.gridnode.gtas.events.partnerprocess;

import com.gridnode.pdip.framework.rpf.event.EventException;
import com.gridnode.pdip.framework.rpf.event.EventSupport;
 
/**
 * This Event class contains the data for retrieving a BizCertMapping base on
 * UID.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0 I7
 * @since 2.0 I7
 */
public class GetBizCertMappingEvent
       extends EventSupport
{
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1302549268170106975L;
	public static final String UID = "BizCertMapping UID";

  public GetBizCertMappingEvent(Long uid)
    throws EventException
  {
    checkSetLong(UID, uid);
  }

  public Long getUID()
  {
    return (Long)getEventData(UID);
  }

  public String getEventName()
  {
    return "java:comp/env/param/event/GetBizCertMappingEvent";
  }

}