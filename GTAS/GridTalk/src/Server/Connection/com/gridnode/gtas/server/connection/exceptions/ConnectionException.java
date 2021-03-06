/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: ConnectionException.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Oct 28 2002    Neo Sok Lay         Created
 */
package com.gridnode.gtas.server.connection.exceptions;

import com.gridnode.pdip.framework.exceptions.ApplicationException;

/**
 * Thrown when a the Connection Service has unresolvable problem with the
 * Connection to GridMaster.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0 I6
 * @since 2.0 I6
 */
public class ConnectionException
  extends    ApplicationException
{ 
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 78605610504810434L;
	private static final String MSG_PREFIX = "Connection Error! - ";

  public ConnectionException(String msg)
  {
    super(MSG_PREFIX+msg);
  }

  public ConnectionException(String msg, Throwable t)
  {
    super(MSG_PREFIX+msg, t);
  }
}