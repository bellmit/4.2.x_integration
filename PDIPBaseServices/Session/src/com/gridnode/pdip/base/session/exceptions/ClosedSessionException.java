/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: ClosedSessionException.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * May 15 2002    Ooi Hui Linn        Created
 * Jun 04 2002    Neo Sok Lay         Extend from ApplicationException instead
 *                                    of BasicTypedException
 */
package com.gridnode.pdip.base.session.exceptions;

import com.gridnode.pdip.framework.exceptions.ApplicationException;

public class ClosedSessionException
  extends    ApplicationException
{ 
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2545901508983760017L;

	public ClosedSessionException(String reason)
  {
    super(reason);
  }

  public ClosedSessionException(Throwable ex)
  {
    super(ex);
  }

  public ClosedSessionException(String reason, Throwable ex)
  {
    super(reason, ex);
  }
}