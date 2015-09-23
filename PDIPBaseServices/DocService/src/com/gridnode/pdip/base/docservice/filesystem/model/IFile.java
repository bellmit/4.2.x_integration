/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: IFile.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Nov 11 2002   Girish R         Created
 */
package com.gridnode.pdip.base.docservice.filesystem.model;


public interface IFile
{

    public static final String ENTITY_NAME = "File";

    public static final Number UID = new Integer(0);  //Integer

    public static final Number FILENAME = new Integer(1);

    public static final Number ISMAINFILE = new Integer(2);

    public static final Number DOCUMENTID = new Integer(3);

    public static final Number PARENTID = new Integer(4);

    public static final Number DOMAINID = new Integer(5);

}
