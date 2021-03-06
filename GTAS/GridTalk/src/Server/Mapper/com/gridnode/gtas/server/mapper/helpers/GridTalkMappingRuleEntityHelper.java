/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GridTalkMappingRuleEntityHelper.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Jun 09 2003    Koh Han Sing        Created
 */
package com.gridnode.gtas.server.mapper.helpers;

import com.gridnode.gtas.server.mapper.model.GridTalkMappingRule;

import com.gridnode.pdip.base.exportconfig.helpers.ICheckConflict;

import com.gridnode.pdip.framework.db.entity.IEntity;
import com.gridnode.pdip.framework.db.filter.DataFilterImpl;

import java.util.Collection;

/**
 * This class contains utitlies methods for the GridTalkMappingRule entity.
 *
 * @author Koh Han Sing
 *
 * @version 2.1 I1
 * @since 2.1 I1
 */

public class GridTalkMappingRuleEntityHelper implements ICheckConflict
{

  private static GridTalkMappingRuleEntityHelper _self = null;

  private GridTalkMappingRuleEntityHelper()
  {
    super();
  }

  public static GridTalkMappingRuleEntityHelper getInstance()
  {
    if(_self == null)
    {
      synchronized(GridTalkMappingRuleEntityHelper.class)
      {
        if (_self == null)
        {
          _self = new GridTalkMappingRuleEntityHelper();
        }
      }
    }
    return _self;
  }

  public IEntity checkDuplicate(IEntity gridTalkMappingRule) throws Exception
  {
    Logger.debug("[GridTalkMappingRuleEntityHelper.checkDuplicate] Start");

    String gridTalkMappingRuleName =
      gridTalkMappingRule.getFieldValue(GridTalkMappingRule.NAME).toString();
    DataFilterImpl filter = new DataFilterImpl();
    filter.addSingleFilter(null,
                           GridTalkMappingRule.NAME,
                           filter.getEqualOperator(),
                           gridTalkMappingRuleName,
                           false);

    GridTalkMappingRuleEntityHandler handler =
      GridTalkMappingRuleEntityHandler.getInstance();
    Collection results = handler.getEntityByFilterForReadOnly(filter);
    if (!results.isEmpty())
    {
      return (GridTalkMappingRule)results.iterator().next();
    }
    return null;
  }
}