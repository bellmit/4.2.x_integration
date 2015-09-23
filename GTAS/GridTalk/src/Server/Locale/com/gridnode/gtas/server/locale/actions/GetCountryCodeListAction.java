/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GetCountryCodeListAction.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Sep 04 2002    Neo Sok Lay         Created
 */
package com.gridnode.gtas.server.locale.actions;

import java.util.Collection;

import com.gridnode.gtas.events.locale.GetCountryCodeListEvent;
import com.gridnode.gtas.server.locale.helpers.LocaleUtil;
import com.gridnode.gtas.server.rdm.ejb.actions.AbstractGetEntityListAction;
import com.gridnode.pdip.framework.db.filter.IDataFilter;

/**
 * This Action class handles the retrieving of a list of CountryCode(s).
 *
 * @author Neo Sok Lay
 *
 * @version 2.0 I5
 * @since 2.0 I5
 */
public class GetCountryCodeListAction
  extends    AbstractGetEntityListAction
{
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -6052190874841720439L;
	public static final String CURSOR_PREFIX = "CountryListCursor.";
  public static final String ACTION_NAME = "GetCountryCodeListAction";

  // ****************** AbstractGetEntityListAction methods *******************

  protected Collection retrieveEntityList(IDataFilter filter)
    throws Exception
  {
    return LocaleUtil.findCountryCodes(filter);
  }

  protected Collection convertToMapObjects(Collection entityList)
  {
    return LocaleUtil.convertCountryCodesToMapObjects(entityList);
  }

  protected String getListIDPrefix()
  {
    return CURSOR_PREFIX;
  }

  // ***************** AbstractGridTalkAction methods ***********************

  protected String getActionName()
  {
    return ACTION_NAME;
  }

  protected Class getExpectedEventClass()
  {
    return GetCountryCodeListEvent.class;
  }

}