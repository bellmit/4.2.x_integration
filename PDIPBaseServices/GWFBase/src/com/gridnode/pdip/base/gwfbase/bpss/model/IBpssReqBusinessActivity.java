/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * May 24 2002    Mahesh              Created
 *
 */
package com.gridnode.pdip.base.gwfbase.bpss.model;


public interface IBpssReqBusinessActivity extends IBpssBusinessAction
{

    /**
     * Name for BpssReqBusinessActivity entity.
     */
    public static final String ENTITY_NAME = "BpssReqBusinessActivity";

    public static final Number TIMETO_ACK_ACCEPT = new Integer(7);  //Boolean

}
