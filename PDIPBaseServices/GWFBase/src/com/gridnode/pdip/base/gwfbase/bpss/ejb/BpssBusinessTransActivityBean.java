// %1023949930374:com.gridnode.pdip.base.gwfbase.bpss.ejb%
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
 */

package com.gridnode.pdip.base.gwfbase.bpss.ejb;

import com.gridnode.pdip.base.gwfbase.bpss.model.BpssBusinessTransActivity;
import com.gridnode.pdip.framework.db.ejb.AbstractEntityBean;

public class BpssBusinessTransActivityBean
  extends AbstractEntityBean
{
  

  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3559608379157411281L;

	protected boolean optimizeEjbStore()
  {
    return true;
  }
  
  //Abstract methods of AbstractEntityBean
  public String getEntityName()
  {
    return BpssBusinessTransActivity.ENTITY_NAME;
  }
}