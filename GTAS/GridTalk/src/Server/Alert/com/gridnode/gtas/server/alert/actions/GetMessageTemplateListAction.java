/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GetMessageTemplateListAction.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * 2003-01-28     Daniel D'Cotta      Created
 */
package com.gridnode.gtas.server.alert.actions;

import java.util.Collection;

import com.gridnode.gtas.events.alert.GetMessageTemplateListEvent;
import com.gridnode.gtas.server.alert.helpers.ActionHelper;
import com.gridnode.gtas.server.alert.helpers.ServiceLookupHelper;
import com.gridnode.gtas.server.rdm.ejb.actions.AbstractGetEntityListAction;
import com.gridnode.pdip.framework.db.filter.IDataFilter;

/**
 * This Action class handles the retrieving of a list of MessageTemplate.
 *
 * @author Daniel D'Cotta
 *
 * @version 2.0
 * @since 2.0
 */
public class GetMessageTemplateListAction
  extends    AbstractGetEntityListAction
{
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 5029986260774840048L;
	public static final String CURSOR_PREFIX = "MessageTemplateListCursor.";
  public static final String ACTION_NAME = "GetMessageTemplateListAction";

  protected Class getExpectedEventClass()
  {
    return GetMessageTemplateListEvent.class;
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
    return ServiceLookupHelper.getAlertManager().getMessageTemplates(filter);
  }

  protected Collection convertToMapObjects(Collection entityList)
  {
    return ActionHelper.convertMessageTemplateToMapObjects(entityList);
  }

}
