/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: UpdatePartnerGroupEvent.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Jun 08 2002    Ang Meng Hua        Created
 */
package com.gridnode.gtas.events.partner;

import com.gridnode.pdip.framework.rpf.event.EventSupport;
import com.gridnode.pdip.framework.rpf.event.EventException;

/**
 * This Event class contains the data for updating a Partner Group.
 *
 * @author Ang Meng Hua
 *
 * @version 2.0
 * @since 2.0
 */
public class UpdatePartnerGroupEvent extends EventSupport
{
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -6434032608543396872L;
	public static final String UID          = "UID";
  public static final String NAME         = "Name";
  public static final String DESCRIPTION  = "Description";

  public UpdatePartnerGroupEvent(Long uID, String name, String description)
    throws EventException
  {
    checkSetLong(UID, uID);
    checkSetString(NAME, name);
    checkSetString(DESCRIPTION, description);
  }

  public Long getUID()
  {
    return (Long)getEventData(UID);
  }

  public String getName()
  {
    return (String)getEventData(NAME);
  }

  public String getDescription()
  {
    return (String)getEventData(DESCRIPTION);
  }

  public String getEventName()
  {
    return "java:comp/env/param/event/UpdatePartnerGroupEvent";
  }

}