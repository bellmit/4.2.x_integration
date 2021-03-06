/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: IGTAccessRightManager.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * 2002-06-08     Andrew Hill         Created
 */
package com.gridnode.gtas.client.ctrl;

import com.gridnode.gtas.client.GTClientException;

import java.util.Collection;

public interface IGTAccessRightManager extends IGTManager
{
  public Collection getAccessRightsForRole(IGTRoleEntity role) throws GTClientException;
}