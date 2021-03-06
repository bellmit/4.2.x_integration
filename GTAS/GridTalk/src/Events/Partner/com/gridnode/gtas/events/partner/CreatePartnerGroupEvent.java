/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: CreatePartnerGroupEvent.java
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
 * This Event class contains the data for the creation of new PartnerGroup.
 *
 * @author Ang Meng Hua
 *
 * @version 2.0
 * @since 2.0
 */
public class CreatePartnerGroupEvent
  extends EventSupport
{ 
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7826770174910447749L;
	public static final String NAME             = "Name";
  public static final String DESCRIPTION      = "Description";
  public static final String PARTNER_TYPE_UID = "Partner Type UID";

  public CreatePartnerGroupEvent(
    String name,
    String description,
    Long   partnerTypeUID)
    throws EventException
  {
    checkSetString(NAME, name);
    checkSetString(DESCRIPTION, description);
    checkSetLong(PARTNER_TYPE_UID, partnerTypeUID);
  }

  public String getName()
  {
    return (String)getEventData(NAME);
  }

  public String getDescription()
  {
    return (String)getEventData(DESCRIPTION);
  }

  public Long getPartnerTypeUID()
  {
    return (Long)getEventData(PARTNER_TYPE_UID);
  }

  public String getEventName()
  {
    return "java:comp/env/param/event/CreatePartnerGroupEvent";
  }

}