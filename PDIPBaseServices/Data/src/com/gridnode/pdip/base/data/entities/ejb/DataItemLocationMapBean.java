/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * June  27 2002	MAHESH              Created
 */
package com.gridnode.pdip.base.data.entities.ejb;

import com.gridnode.pdip.base.data.entities.model.DataItemLocationMap;
import com.gridnode.pdip.framework.db.ejb.AbstractEntityBean;
 
public class DataItemLocationMapBean extends AbstractEntityBean {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7334218533031886876L;

	//Abstract methods of AbstractEntityBean
	public String getEntityName(){
		return DataItemLocationMap.ENTITY_NAME;
	}
}