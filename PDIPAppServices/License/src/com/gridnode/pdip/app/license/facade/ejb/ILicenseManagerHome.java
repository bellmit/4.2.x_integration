/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: ILicenseManagerHome.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Sep 05 2002    Neo Sok Lay         Created
 */
package com.gridnode.pdip.app.license.facade.ejb;

import javax.ejb.EJBHome;
import javax.ejb.CreateException;

import java.rmi.RemoteException;

/**
 * LocalHome interface for LicenseManagerBean.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0 I4
 * @since 2.0 I4
 */
public interface ILicenseManagerHome
  extends        EJBHome
{
  /**
   * Create the LicenseManagerBean.
   *
   * @returns EJBObject for the LicenseManagerBean.
   */
  public ILicenseManagerObj create()
    throws CreateException, RemoteException;
}