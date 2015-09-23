// %1023949934811:com.gridnode.pdip.base.gwfbase.xpdl.ejb%
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

package com.gridnode.pdip.base.gwfbase.xpdl.ejb;

import com.gridnode.pdip.base.gwfbase.xpdl.model.XpdlParticipantList;
import com.gridnode.pdip.framework.db.ejb.AbstractEntityBean;
 
public class XpdlParticipantListBean
  extends AbstractEntityBean
{

  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1310522507158911941L;

	protected boolean optimizeEjbStore()
  {
    return true;
  }

  //Abstract methods of AbstractEntityBean
  public String getEntityName()
  {
    return XpdlParticipantList.ENTITY_NAME;
  }
}