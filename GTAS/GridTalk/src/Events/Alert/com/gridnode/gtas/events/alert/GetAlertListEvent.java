/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GetAlertListEvent.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * 2003-01-28     Daniel D'Cotta      Created
 */
package com.gridnode.gtas.events.alert;

import com.gridnode.pdip.framework.db.filter.IDataFilter;
import com.gridnode.pdip.framework.rpf.event.GetEntityListEvent;
import com.gridnode.pdip.framework.rpf.event.EventException;

/**
 * This Event class contains the data for retrieve a list of Alert,
 * optionally based on a filtering condition.
 *
 * @author Daniel D'Cotta
 *
 * @version 2.0
 * @since 2.0
 */
public class GetAlertListEvent
  extends    GetEntityListEvent
{
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2053725470210944152L;

	public GetAlertListEvent()
  {
    super();
  }

  public GetAlertListEvent(IDataFilter filter)
  {
    super(filter);
  }

  public GetAlertListEvent(IDataFilter filter, int maxRows)
  {
    super(filter, maxRows);
  }

  public GetAlertListEvent(IDataFilter filter, int maxRows, int startRow)
  {
    super(filter, maxRows, startRow);
  }

  public GetAlertListEvent(String listID, int maxRows, int startRow)
    throws EventException
  {
    super(listID, maxRows, startRow);
  }

  public String getEventName()
  {
    return "java:comp/env/param/event/GetAlertListEvent";
  }
}