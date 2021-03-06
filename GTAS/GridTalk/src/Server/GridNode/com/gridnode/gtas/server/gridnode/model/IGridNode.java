/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: IGridNode.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Sep 17 2002    Neo Sok Lay         Created
 */
package com.gridnode.gtas.server.gridnode.model;

/**
 * This interface defines the field IDs and constants for GridNode entity.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0 I5
 * @since 2.0 I5
 */
public interface IGridNode
{
  /**
   * Name of GridNode entity
   */
  static final String ENTITY_NAME   = "GridNode";

  /**
   * FieldID for UID. A Long.
   */
  static final Number UID           = new Integer(0);

  /**
   * FieldID for GridNodeID. A String.
   */
  static final Number ID            = new Integer(1); // String(10)

  /**
   * FieldID for GridNodeName. A String.
   */
  static final Number NAME          = new Integer(2); // String(80)

  /**
   * FieldID for GridNodeCategory. A String.
   */
  static final Number CATEGORY      = new Integer(3); // String(3)

  /**
   * FieldID for State. A Short.
   */
  static final Number STATE         = new Integer(4);

  /**
   * FieldID for ActivationReason.  A String.
   */
  static final Number ACTIVATION_REASON = new Integer(5); // String(255)

  /**
   * FieldID for DTCreated. A Timestamp.
   */
  static final Number DT_CREATED        = new Integer(6);

  /**
   * FieldID for DTReqActivate. A Timestamp.
   */
  static final Number DT_REQ_ACTIVATE   = new Integer(7);

  /**
   * FieldID for DTActivated. A Timestamp.
   */
  static final Number DT_ACTIVATED      = new Integer(8);

  /**
   * FieldID for DTDeactivated. A Timestamp.
   */
  static final Number DT_DEACTIVATED    = new Integer(9);

  /**
   * FieldID for CompanyProfileUID. A Long.
   */
  static final Number COY_PROFILE_UID   = new Integer(10);

  /**
   * FieldID for Version. A Double.
   */
  static final Number VERSION     = new Integer(11);


  // Values for STATE

  /**
   * Possible value for STATE. This indicates that the GridNode belongs to "This"
   * GridTalk.
   */
  static final short STATE_ME             = 0;

  /**
   * Possible value for STATE. This indicates that the GridNode has been marked
   * deleted from the system.
   */
  static final short STATE_DELETED        = 1;

  /**
   * Possible value for STATE. This indicates that the GridNode is an activated
   * partner of the enterprise.
   */
  static final short STATE_ACTIVE         = 2;

  /**
   * Possible value for STATE. This indicates that the GridNode is not an
   * activated partner of the enterprise.
   */
  static final short STATE_INACTIVE       = 3;

  /**
   * Possible value for STATE. This indicates that the GridNode belongs to
   * the GridMaster server.
   */
  static final short STATE_GM             = 4;

  /**
   * Possible value for STATE. This indicates that the GridNode has been newly
   * searched and added to the system.
   */
//  static final short STATE_NEW            = 2;

  /**
   * Possible value for STATE. This indicates that the GridNode is an activated
   * partner.
   */
//  static final short STATE_ACTIVATED      = 3;

  /**
   * Possible value for STATE. This indicates that the GridNode, which was an
   * activated partner, is now deactivated by one party.
   */
//  static final short STATE_DEACTIVATED    = 4;

  /**
   * Possible value for STATE. This indicates that the GridNode has requested
   * for activation, and is now pending for authorisation by this GridTalk.
   */
//  static final short STATE_IN_PENDING     = 5;

  /**
   * Possible value for STATE. This indicates that the GridNode is being requested
   * for activation, and is now pending for authorisation by the GridTalk of
   * the GridNode.
   */
//  static final short STATE_OUT_PENDING    = 6;

  /**
   * Possible value for STATE. This indicates that the activation request from
   * the GridNode is being denied by this GridTalk.
   */
//  static final short STATE_IN_DENIED      = 7;

  /**
   * Possible value for STATE. This indicates that the activation request to
   * the GridNode is being denied by the GridTalk of the GridNode.
   */
//  static final short STATE_OUT_REJECTED   = 8;

  /**
   * Possible value for STATE. This indicates that the activation request to
   * the GridNode is aborted by this GridTalk.
   */
//  static final short STATE_OUT_ABORTED    = 9;

  /**
   * Possible value for STATE. This indicates that the gridnode is a connection
   * server i.e. a GridMaster.s
   */
//  static final short STATE_SERVER         = 10;

}