/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * May 21 2002    MAHESH              Created
 */
package com.gridnode.pdip.base.gwfbase.xpdl.model;


public interface IXpdlApplication
{

    //Entity name for XpdlApplication
    public static final String ENTITY_NAME = "XpdlApplication";

    //FieldIds for attributes in XpdlApplication

    public static final Number UID = new Integer(0);  //Long

    public static final Number APPLICATION_ID = new Integer(1);  //String;

    public static final Number APPLICATION_NAME = new Integer(2);  //String;

    public static final Number APPLICATION_DESCRIPTION = new Integer(3);  //String;

    public static final Number EXTENDED_ATTRIBUTES = new Integer(4);  //Long;

    public static final Number PROCESS_ID = new Integer(5);  //String;

    public static final Number PACKAGE_ID = new Integer(6);  //String;

    public static final Number PKG_VERSION_ID = new Integer(7);  //String;

}
