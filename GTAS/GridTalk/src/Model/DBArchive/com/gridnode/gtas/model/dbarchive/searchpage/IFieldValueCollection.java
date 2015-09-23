/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2005 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: IFieldValueCollection.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Oct 20, 2005        Tam Wei Xiang       Created
 * Oct 20, 2005				 Sumedh C.					 Adopt IFieldValueCollection.java (in server layer) to use in model layer.
 */
package com.gridnode.gtas.model.dbarchive.searchpage;

public interface IFieldValueCollection
{
	/**
   * Name for this entity.
   */
  public static final String ENTITY_NAME = "FieldValueCollection";
  
  /**
   * The following is the fieldID for the respective field(eg value). 
   * Their type is stated after the declaration of the Number object.
   */
  public static final Number UID = new Integer(0);  //Long
  
  /**
   * FieldId for Whether-the-Activity-can-be-deleted flag. A Boolean.
   */
  public static final Number CAN_DELETE  = new Integer(1); //Boolean

  public static final Number VERSION       = new Integer(2); //Double
  
  public static final Number Value = new Integer(3);  //ArrayList
  
//Constant for retrieving list of code value
  public static final Long PROCESS_DEF = new Long(10);
  public static final Long PARTNER_ID = new Long(11);
  public static final Long DOC_TYPE = new Long(12);
  public static final Long PROCESS_STATE = new Long(13);
}
