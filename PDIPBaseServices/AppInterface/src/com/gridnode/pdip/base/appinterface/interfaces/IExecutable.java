/* Generated by Together */

package com.gridnode.pdip.base.appinterface.interfaces;

import com.gridnode.pdip.base.appinterface.data.*;
import com.gridnode.pdip.base.appinterface.exception.*;

public interface IExecutable extends IAppConstants {

  public AppParam execute(AppParam param) throws AppExecutionException;

  public int getAppType();

  public void setAppType(int type);
  
}
