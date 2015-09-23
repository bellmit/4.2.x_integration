/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: ICertificateLocalHome
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * JUL 03 2002    Jagadeesh        Created
 */


package com.gridnode.pdip.base.certificate.entities.ejb;


import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

import com.gridnode.pdip.framework.db.entity.IEntity;
import com.gridnode.pdip.framework.db.filter.IDataFilter;



public interface ICertificateLocalHome extends EJBLocalHome
{
  /**
   * Create the local entity EJB object
   *
   * @param entity The entity value object
   * @return The newly created local entity EJB object
   */
  public ICertificateLocalObj create(IEntity entity)
    throws CreateException;

  /**
   * Find an entity by its primary key (UID)
   *
   * @param primaryKey The primary key to the record
   * @return The local entity EJB object for the found record.
   */
  public ICertificateLocalObj findByPrimaryKey(Long primaryKey)
    throws FinderException;

  /**
   * Find all entities using a data filter.
   *
   * @param filter The data filter that encapsulates the find criteria
   * @return A Collection of the local entity EJB objects for the found records.
   */
  public Collection findByFilter(IDataFilter filter)
    throws FinderException;


}