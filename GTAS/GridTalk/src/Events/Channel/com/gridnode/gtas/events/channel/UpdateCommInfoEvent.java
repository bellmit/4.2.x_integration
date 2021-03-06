/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: UpdateJMSCommInfoEvent.java
 *
 ****************************************************************************
 * Date           Author                  Changes
 ****************************************************************************
 * Jun 18 2002    Goh Kan Mun             Created
 * Jul 05 2002    Goh Kan Mun             Modified - add in new fields.
 * Oct 04 2002    Ang Meng Hua            Removed RefID, isPartner, PartnerCategoty
 *                                        and isDisable from event constructor
 */

package com.gridnode.gtas.events.channel;

/**
 * This event class contains the data for creation of a CommInfo.
 *
 *
 * @author Goh Kan Mun
 *
 * @version 2.0
 * @since 2.0
 */

import com.gridnode.pdip.framework.rpf.event.EventException;
import com.gridnode.pdip.framework.rpf.event.EventSupport;

public class UpdateCommInfoEvent extends EventSupport
{

  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -3783293910777470397L;

	/**
   * FieldId for UId.
   */
  public static final String UID = "uId";

  /**
   * FieldId for Name given by the user.
   */
  public static final String NAME = "Name";

  /**
   * FieldId for Description given by the user.
   */
  public static final String DESCRIPTION = "Description";

  /**
   * FieldId for isPartner information.
   */
  public static final String IS_PARTNER = "IS Partner";

  /**
   * FieldId for URL information.
   */

  public static final String URL = "Url";

  /**
   * FieldId for Protocol Type information.
   */

  public static final String PROTOCOL_TYPE = "Protocol Type";

  public UpdateCommInfoEvent(
    Long uId,
    String  name,
    String  description,
    String url,
    String protocolType,
    Boolean isPartner)
    throws EventException
  {
    checkSetString(NAME, name);
    setEventData(DESCRIPTION, description);
    checkSetString(URL,url);
    checkSetString(PROTOCOL_TYPE,protocolType);
    setEventData(IS_PARTNER,isPartner);
    setEventData(UID, uId);
  }

  public Long getUId()
  {
    return (Long) getEventData(UID);
  }

  public String getDescription()
  {
    return (String) getEventData(DESCRIPTION);
  }


  public String getName()
  {
    return (String) getEventData(NAME);
  }

  public String getURL()
  {
    return (String) getEventData(URL);
  }

  public String getProtocolType()
  {
    return (String) getEventData(PROTOCOL_TYPE);
  }

  public Boolean isPartner()
  {
    return  (Boolean) getEventData(IS_PARTNER);
  }

//  public String getPartnerCategory()
//  {
//    return (String) getEventData(PARTNER_CAT);
//  }
//
//  public Boolean isDisable()
//  {
//    return (Boolean) getEventData(IS_DISABLE);
//  }


  public String getEventName()
  {
    return "java:comp/env/param/event/UpdateCommInfoEvent";
  }


}


