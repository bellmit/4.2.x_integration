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
 * Jul 29 2002    Neo Sok Lay         Created
 * Jan 07 2003    Neo Sok Lay         Add FacadeLogger for BizRegistryManagerBean.
 * Aug 12 2003    Neo Sok Lay         Add FacadeLogger for PublicRegistryManagerBean.
 * Feb 13 2007		Chong SoonFui				Deprecate err(...) 
 * 																		Add error(...) and warn(...)
 */
package com.gridnode.pdip.app.bizreg.helpers;

import com.gridnode.pdip.framework.log.FacadeLogger;
import com.gridnode.pdip.framework.log.Log;

/**
 * This class handles the logging for the BusinessRegistry module.
 *
 * @author Neo Sok Lay
 *
 * @version GT 4.0 VAN
 * @since 2.0 I4
 */
public class Logger
{
  private static final String CATEGORY_MAIN = "APP.BIZREG";

  private static final String[] MGR_FACADE = {
                                               CATEGORY_MAIN + ".MGR",
                                               "BizRegistryManagerBean",
                                             };

  private static final String[] PUB_FACADE = {
                                               CATEGORY_MAIN + ".PUB",
                                               "PublicRegistryManagerBean",
                                             };

  private static final String[] SEARCH_FACADE = {
                                               CATEGORY_MAIN + ".SEARCH",
                                               "SearchListenerMDBean",
                                             };

  private static final int CATEGORY_INDEX    = 0;
  private static final int FACADE_INDEX = 1;

  /**
   * Get the FacadeLogger for the BizRegManager facade.
   */
  public static FacadeLogger getManagerFacadeLogger()
  {
    return FacadeLogger.getLogger(
            MGR_FACADE[FACADE_INDEX], MGR_FACADE[CATEGORY_INDEX]);
  }

  /**
   * Get the FacadeLogger for the PublicRegistryManager facade.
   */
  public static FacadeLogger getPublicRegistryFacadeLogger()
  {
    return FacadeLogger.getLogger(
            PUB_FACADE[FACADE_INDEX], PUB_FACADE[CATEGORY_INDEX]);
  }

  /**
   * Get the FacadeLogger for the search registry facade.
   */
  public static FacadeLogger getSearchFacadeLogger()
  {
    return FacadeLogger.getLogger(
            SEARCH_FACADE[FACADE_INDEX], SEARCH_FACADE[CATEGORY_INDEX]);
  }

  public static void log(Object msg)
  {
    Log.log(CATEGORY_MAIN, msg);
  }

  public static void debug(Object msg)
  {
    Log.debug(CATEGORY_MAIN, msg);
  }

  public static void debug(String msg, Throwable ex)
  {
    Log.debug(CATEGORY_MAIN, msg, ex);
  }

  /**
   * Log a warning message with the specified category
   * @param msg The warning message
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void warn(Object msg)
  {
    Log.warn(CATEGORY_MAIN, msg);
  }

  /**
   * Log a warning message with the specified category and
   * <code>Throwable</code> object of origin
   * 
   * @param msg The warning message
   * @param ex The <code>Throwable</code> object of origin
   * 
   * @since GT 4.0 VAN
   * @version GT 4.0 VAN
   */
  public static void warn(String msg, Throwable ex)
  {
    Log.warn(CATEGORY_MAIN, msg, ex);
  }
  
  /**
   * @deprecated Use error(String, Object)
   * @see Logger#error(String, Object)
   * @param msg
   */
  public static void err(Object msg)
  {
    Log.err(CATEGORY_MAIN, msg);
  }

  /**
   * @deprecated Use error(String,String,Throwable)
   * @param msg
   * @param ex
   */
  public static void err(String msg, Throwable ex)
  {
    Log.err(CATEGORY_MAIN, msg, ex);
  }

  /**
   * Log an error message with the specified error code
   * @see com.gridnode.pdip.app.bizreg.exceptions.ILogErrorCodes
   * 
   * @param errorCode
   * @param msg
   */
  public static void error(String errorCode, Object msg)
  {
    Log.error(errorCode, CATEGORY_MAIN, msg);
  }

  /**
   * Log an error message with the specified error code and
   * <code>Throwable</code> object of origin
   * @see com.gridnode.pdip.app.bizreg.exceptions.ILogErrorCodes
   * 
   * @param errorCode The error code
   * @param msg The error message
   * @param t The <code>Throwable</code> object of origin
   */
  public static void error(String errorCode, String msg, Throwable t)
  {
    Log.error(errorCode, CATEGORY_MAIN, msg, t);
  }
}