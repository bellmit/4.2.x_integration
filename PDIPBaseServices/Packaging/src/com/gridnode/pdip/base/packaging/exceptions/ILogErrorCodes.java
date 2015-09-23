/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2007 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: ILogErrorCodes.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Feb 12 2007		Chong SoonFui				Created
 */
package com.gridnode.pdip.base.packaging.exceptions;

/**
 * Error codes for PDIP-Base-Packaging Module 
 * @author Chong SoonFui
 * @since GT 4.0 VAN
 * @version GT 4.0 VAN
 */
public interface ILogErrorCodes
{
	public static final String PREFIX = "002.010.";
	
	/**
	 * 002.010.001: Error while creating zip file
	 */
	public static final String PACKAGING_ZIP_FILE_CREATE = PREFIX+"001";
	
	/**
	 * 002.010.002: Error while initializing event map
	 */
	public static final String PACKAGING_EVENTMAP_INITIALIZE = PREFIX+"002";
	
}
