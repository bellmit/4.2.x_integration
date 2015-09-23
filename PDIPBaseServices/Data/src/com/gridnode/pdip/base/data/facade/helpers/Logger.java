/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File:
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Jun 10 2002   Mahesh	      Created
 * Jun 13 2002   Mathew         Repackaged
 * Feb 09 2007		Alain Ah Ming				Deprecate err(...) 
 * 																		Add error(...) and warn(...)
 */
package com.gridnode.pdip.base.data.facade.helpers;

import com.gridnode.pdip.framework.log.Log;

/**
 * This class handles the logging for the Data module.
 * 
 * @author Mahesh
 * @since
 * @version GT 4.0 VAN
 */
public class Logger
{
  private static final String CATEGORY = "BASE.DATA";

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
   * Log a warning message with the specified <code>Throwable</code>
   * object of origin
   * 
   * @param msg The warning message
   * @param ex The <code>Throwable</code> object of origin
   * 
   * @since GT 4.0 VAN
   * @since GT 4.0 VAN
   */
  public static void warn(String msg, Throwable ex)
  {
    Log.warn(CATEGORY, msg, ex);
  }

  /**
   * @deprecated Use error(String,String)
   * @param msg
   */
  public static void err(Object msg)
  {
    Log.err(CATEGORY, msg);
  }

  /**
   * @deprecated Use error(String,String,Throwable)
   * @param msg
   * @param ex
   */
  public static void err(String msg, Throwable ex)
  {
    Log.err(CATEGORY, msg, ex);
  }

  /**
   * Log an error message with the specified error code
   * @see com.gridnode.pdip.base.data.exceptions.ILogErrorCodes
   * 
   * @param errorCode
   * @param msg
   */
  public static void error(String errorCode, Object msg)
  {
    Log.error(errorCode, CATEGORY, msg);
  }

  /**
   * Log an error message with the specified error code and
   * <code>Throwable</code> object of origin
   * @see com.gridnode.pdip.base.data.exceptions.ILogErrorCodes
   * 
   * @param errorCode The error code
   * @param msg The error message
   * @param t The <code>Throwable</code> object of origin
   */
  public static void error(String errorCode, String msg, Throwable t)
  {
    Log.error(errorCode, CATEGORY, msg, t);
  }

  public static void log(String category, Object msg)
  {
    Log.log(CATEGORY+"."+category, msg);
  }

  public static void debug(String category, Object msg)
  {
    Log.debug(CATEGORY+"."+category, msg);
  }

  public static void debug(String category, String msg, Throwable ex)
  {
    Log.debug(CATEGORY+"."+category, msg, ex);
  }

  /**
   * Log a warning message with the specified category
   * @param category The warning message category
   * @param msg The warning message
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void warn(String category, Object msg)
  {
    Log.warn(CATEGORY+"."+category, msg);
  }

  /**
   * Log a warning message with the specified category and
   * <code>Throwable</code> object of origin
   * 
   * @param category The warning message category
   * @param msg The warning message
   * @param ex The <code>Throwable</code> object of origin
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void warn(String category, String msg, Throwable ex)
  {
    Log.warn(CATEGORY+"."+category, msg, ex);
  }
  
  /**
   * @deprecated Use error(String, String, Object)
   * @see Logger#error(String, String, Object)
   * @param category
   * @param msg
   */
  public static void err(String category, Object msg)
  {
    Log.err(CATEGORY+"."+category, msg);
  }

  /**
   * @deprecated Use error(String, String, String, Throwable)
   * @see Logger#error(String, String, String, Throwable)
   * @param category
   * @param msg
   * @param ex
   */
  public static void err(String category, String msg, Throwable ex)
  {
    Log.err(CATEGORY+"."+category, msg, ex);
  }

  /**
   * Log an error message with the specified error code and category
   * 
   * @see com.gridnode.pdip.base.data.exceptions.ILogErrorCodes
   * 
   * @param errorCode The error code
   * @param category The error category
   * @param msg The error message
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void error(String errorCode, String category, Object msg)
  {
    Log.error(errorCode, CATEGORY+"."+category, msg);
  }

  /**
   * Log an error message with the specified error code, category and
   * <code>Throwable</code> object of origin
   * @see com.gridnode.pdip.base.data.exceptions.ILogErrorCodes
   * 
   * @param errorCode The error code
   * @param category The error category
   * @param msg The error message
   * @param ex The <code>Throwable</code> object of origin
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void error(String errorCode, String category, String msg, Throwable ex)
  {
    Log.error(errorCode, CATEGORY+"."+category, msg, ex);
  }
}