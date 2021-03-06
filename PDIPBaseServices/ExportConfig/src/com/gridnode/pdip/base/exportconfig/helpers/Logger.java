/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: Logger.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * May 12 2003    Koh Han Sing        Created
 * Feb 09 2007		Alain Ah Ming				Deprecate err(...)
 * 																		Add error(...) with error code and warn(...)
 */
package com.gridnode.pdip.base.exportconfig.helpers;

import com.gridnode.pdip.framework.log.Log;

/**
 * This class handles the logging for the ExportConfig module.
 *
 * @author Koh Han Sing
 *
 * @version GT 4.0 VAN
 * @since 2.1 I1
 */
public class Logger
{
  private static final String CATEGORY = "GTAS.EXPORTCONFIG";

  public static void log(Object msg)
  {
    Log.log(CATEGORY, msg);
  }

  public static void debug(Object msg)
  {
    Log.debug(CATEGORY, msg);
  }

  public static void debug(String msg, Throwable ex)
  {
    Log.debug(CATEGORY, msg, ex);
  }

  /**
   * Log a warning message
   * @param msg The warning message
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void warn(Object msg)
  {
    Log.warn(CATEGORY, msg);
  }

  /**
   * Log a warning message with the specified
   * <code>Throwable</code> object of origin
   * @param msg The warning message
   * @param t The <code>Throwable</code> object of origin
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void warn(String msg, Throwable t)
  {
    Log.warn(CATEGORY, msg, t);
  }

  /**
   * @deprecated
   * @see #error(String, Object)
   * @param msg
   */
  public static void err(Object msg)
  {
    Log.err(CATEGORY, msg);
  }

  /**
   * @deprecated
   * @see #error(String, String, Throwable)
   * @param msg
   * @param ex
   */
  public static void err(String msg, Throwable ex)
  {
    Log.err(CATEGORY, msg, ex);
  }

  /**
   * Log an error message with the specified error code
   * @see com.gridnode.pdip.base.exportconfig.exception.IlogErrorCodes
   * 
   * @param errorCode The error code
   * @param msg The error message
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void error(String errorCode, Object msg)
  {
    Log.error(errorCode, CATEGORY, msg);
  }

  /**
   * Log an error message with the specified error code, message
   * and <code>Throwable</code> object of origin
   * @see com.gridnode.pdip.base.exportconfig.exception.IlogErrorCodes
   * 
   * @param errorCode The error code
   * @param msg The error message
   * @param t The <code>Throwable</code> object of origin
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void error(String errorCode, String msg, Throwable t)
  {
    Log.error(errorCode, CATEGORY, msg, t);
  }
}