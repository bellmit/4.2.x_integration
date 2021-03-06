

package com.gridnode.pdip.app.rnif.entities.ejb;


import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

import com.gridnode.pdip.framework.db.entity.IEntity;
import com.gridnode.pdip.framework.db.filter.IDataFilter;
public interface IProcessDefLocalHome extends EJBLocalHome {
	public IProcessDefLocalObj create(IEntity data)
 		throws CreateException;

	public IProcessDefLocalObj findByPrimaryKey(Long primaryKey)
		throws FinderException;

	public Collection findByFilter(IDataFilter filter)
		 throws FinderException;
}
