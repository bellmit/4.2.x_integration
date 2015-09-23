/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: IPartnerType.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Jun 04 2002    Ang Meng Hua        Created
 */
package com.gridnode.pdip.app.partner.model;

/**
 * This interface defines the properties and fieldIDs for accessing fields
 * in PartnerType entity.
 *
 * @author Ang Meng Hua
 *
 * @version 2.0
 * @since 2.0.1
 */
public interface IPartnerType
{
  /**
   * Name for PartnerType entity.
   */
  public static final String  ENTITY_NAME = "PartnerType";

  /**
   * FieldId for UId. A Number.
   */
  public static final Number UID = new Integer(0);  //Integer

  /**
   * FieldId for Version. A double.
   */
  public static final Number VERSION = new Integer(1); //Double

  /**
   * FieldId for CanDelete.
   */
  public static final Number CAN_DELETE = new Integer(2); // Boolean

  /**
   * FieldId for the Name of the PartnerType. A String.
   */
  public static final Number NAME = new Integer(3);  //String

  /**
   * FieldId for Desc. A String.
   */
  public static final Number DESCRIPTION = new Integer(4);  //String
}