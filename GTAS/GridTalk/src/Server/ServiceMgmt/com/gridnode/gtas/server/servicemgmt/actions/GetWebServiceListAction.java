/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2003 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GetWebServiceListAction.java
 *
 ****************************************************************************
 * Date      				Author              Changes
 ****************************************************************************
 * Feb 9, 2004 			Mahesh             	Created
 */
package com.gridnode.gtas.server.servicemgmt.actions;

import java.util.Collection;

import com.gridnode.gtas.events.servicemgmt.GetWebServiceListEvent;
import com.gridnode.gtas.server.rdm.ejb.actions.AbstractGetEntityListAction;
import com.gridnode.gtas.server.servicemgmt.helpers.ActionHelper;
import com.gridnode.pdip.framework.db.filter.IDataFilter;

public class GetWebServiceListAction
  extends    AbstractGetEntityListAction
{ 
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 161991403351642603L;
	public static final String CURSOR_PREFIX = "WebServiceListCursor.";
  public static final String ACTION_NAME = "GetWebServiceListAction";

  protected Class getExpectedEventClass()
  {
    return GetWebServiceListEvent.class;
  }

  protected String getActionName()
  {
    return ACTION_NAME;
  }

  protected String getListIDPrefix()
  {
    return CURSOR_PREFIX;
  }

  protected Collection retrieveEntityList(IDataFilter filter)
    throws Exception
  {
    Collection webServices = ActionHelper.getManager().findWebServices(filter);
    return webServices;
  }

  protected Collection convertToMapObjects(Collection entityList)
  {
    return ActionHelper.convertWebServiceToMapObjects(entityList);
  }

}
