/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GetNetworkSettingEvent.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Oct 21 2002    Neo Sok Lay         Created
 */
package com.gridnode.gtas.events.connection;

import com.gridnode.pdip.framework.rpf.event.EventSupport;
 
/**
 * This Event class contains the data for retrieve the NetworkSetting.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0 I6
 * @since 2.0 I6
 */
public class GetNetworkSettingEvent
  extends    EventSupport
{
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -3928731782702812553L;

	public GetNetworkSettingEvent()
  {
  }

  public String getEventName()
  {
    return "java:comp/env/param/event/GetNetworkSettingEvent";
  }


}