/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: CreateDirectoryException.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Dec 19 2002    Koh Han Sing        Port to GTAS
 */
package com.gridnode.gtas.backend.exception;

/**
 * Title:        GridNode Backend
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      GridNode Pte Ltd
 * @author
 * @version 1.0
 */

public class CreateDirectoryException extends Exception
{ 
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -648766053611427530L;

	public CreateDirectoryException(String s)
  {
    super(s);
  }
}