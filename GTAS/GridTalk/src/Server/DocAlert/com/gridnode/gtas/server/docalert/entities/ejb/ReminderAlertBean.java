/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: ReminderAlertBean.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Jan 25 2003    Neo Sok Lay         Created
 */
package com.gridnode.gtas.server.docalert.entities.ejb;

import com.gridnode.gtas.server.docalert.helpers.ReminderAlertDAOHelper;
import com.gridnode.gtas.server.docalert.model.ReminderAlert;
import com.gridnode.pdip.framework.db.ejb.AbstractEntityBean;
import com.gridnode.pdip.framework.db.entity.IEntity;

/**
 * A ReminderAlertBean provides persistency services for ReminderAlert.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0 I7
 * @since 2.0 I7
 */
public class ReminderAlertBean extends AbstractEntityBean
{
  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4711931807346151501L;

	public String getEntityName()
  {
    return ReminderAlert.ENTITY_NAME;
  }

  protected void checkDuplicate(IEntity reminderAlert)
    throws Exception
  {
    ReminderAlertDAOHelper.getInstance().checkDuplicate(
      (ReminderAlert)reminderAlert, false);
  }

}