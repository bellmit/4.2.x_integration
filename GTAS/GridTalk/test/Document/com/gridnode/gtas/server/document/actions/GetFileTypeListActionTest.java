/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: GetFileTypeListActionTest.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * May 03 2002    Neo Sok Lay         Created
 * Jul 29 2002    Koh Han Sing        Modified to use for
 *                                    GetFileTypeListAction
 */
package com.gridnode.gtas.server.document.actions;

import com.gridnode.gtas.model.document.IFileType;
import com.gridnode.gtas.events.document.GetFileTypeListEvent;
import com.gridnode.gtas.exceptions.IErrorCode;
import com.gridnode.gtas.server.rdm.IAttributeKeys;

import com.gridnode.gtas.server.document.model.FileType;
import com.gridnode.gtas.server.document.facade.ejb.*;

import com.gridnode.pdip.base.session.facade.ejb.ISessionManagerHome;
import com.gridnode.pdip.base.session.facade.ejb.ISessionManagerObj;

import com.gridnode.pdip.framework.exceptions.SystemException;
import com.gridnode.pdip.framework.j2ee.ServiceLookup;
import com.gridnode.pdip.framework.rpf.event.*;
import com.gridnode.pdip.framework.rpf.ejb.StateMachine;
import com.gridnode.pdip.framework.log.Log;
import com.gridnode.pdip.framework.db.filter.DataFilterImpl;
import com.gridnode.pdip.framework.db.filter.IDataFilter;
import com.gridnode.pdip.framework.util.PasswordMask;

import junit.framework.*;

import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This Test case tests the GetFileTypeListActionTest class.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0
 * @since 2.0
 */
public class GetFileTypeListActionTest extends TestCase
{
  static final String _FILE_TYPE    = "test";
  static final String _DESCRIPTION  = "GetList Description";
  static final String _PROGRAM_NAME = "GetList Program Name";
  static final String _PROGRAM_PATH = "GetList Program Path";
  static final String _PARAMETERS   = "GetList Parameters";
  static final String _WORKING_DIR  = "GetList Working Directory";

  static final int _LIST_COUNT = 9;
  static final int _MAX_PAGE_ENTRIES = 4;
  static final int _START_ROW = 6;
  static final ArrayList _TEST_FILETYPES = new ArrayList();
  static final DataFilterImpl _FILTER = new DataFilterImpl();
  static
  {
    for (int i=0; i<_LIST_COUNT; i++)
      _TEST_FILETYPES.add(_FILE_TYPE+i);

    _FILTER.addDomainFilter(null, FileType.FILE_TYPE, _TEST_FILETYPES, false);
    _FILTER.setOrderFields(new Number[] {FileType.UID});
  }

  ISessionManagerHome _sessionHome;
  ISessionManagerObj _sessionRemote;
  String _sessionID;
  String _userID = "admin";

  BasicEventResponse _response;
  GetFileTypeListEvent _event;
  IDocumentManagerHome _home;
  IDocumentManagerObj _remote;
  FileType _fileType;
  StateMachine _sm = new StateMachine(null, null);

  public GetFileTypeListActionTest(String name)
  {
    super(name);
  }

  public static Test suite()
  {
    return new TestSuite(GetFileTypeListActionTest.class);
  }

  public static void main(String args[])
  {
    junit.textui.TestRunner.run(suite());
  }

  protected void setUp() throws java.lang.Exception
  {
    Log.log("TEST", "[GetFileTypeListActionTest.setUp] Enter");

    _sessionHome = (ISessionManagerHome)ServiceLookup.getInstance(
                   ServiceLookup.CLIENT_CONTEXT).getHome(
                   ISessionManagerHome.class);
    assertNotNull("SessionHome is null", _sessionHome);
    _sessionRemote = _sessionHome.create();
    assertNotNull("SessionRemote is null", _sessionRemote);
    _sessionID = _sessionRemote.openSession();
    _sessionRemote.authSession(_sessionID, _userID);

    _home = (IDocumentManagerHome)ServiceLookup.getInstance(
             ServiceLookup.CLIENT_CONTEXT).getHome(
             IDocumentManagerHome.class);
    assertNotNull("Home is null", _home);
    _remote = _home.create();
    assertNotNull("remote is null", _remote);

    deleteTestData(); //prevent error in create
    for (int i=0; i<_LIST_COUNT; i++)
    {
      createTestData(_FILE_TYPE+i,
                     _DESCRIPTION+i,
                     _PROGRAM_NAME+i,
                     _PROGRAM_PATH+i,
                     _PARAMETERS+i,
                     _WORKING_DIR+i);
    }

    Log.log("TEST", "[GetFileTypeListActionTest.setUp] Exit");
  }

  protected void tearDown() throws java.lang.Exception
  {
    Log.log("TEST", "[GetFileTypeListActionTest.tearDown] Enter");
    deleteTestData();
    Log.log("TEST", "[GetFileTypeListActionTest.tearDown] Exit");
  }

  private GetFileTypeListEvent createTestEvent(IDataFilter filter)
  {
    return new GetFileTypeListEvent(filter);
  }

  private GetFileTypeListEvent createTestEvent(
    IDataFilter filter, int maxRows)
  {
    return new GetFileTypeListEvent(filter, maxRows);
  }

  private GetFileTypeListEvent createTestEvent(
    IDataFilter filter, int maxRows, int startRow)
  {
    return new GetFileTypeListEvent(filter, maxRows, startRow);
  }

  private GetFileTypeListEvent createTestEvent(
    String listID, int maxRows, int startRow) throws Exception
  {
    return new GetFileTypeListEvent(listID, maxRows, startRow);
  }

  private BasicEventResponse performEvent(IEvent event)
    throws Exception
  {
    GetFileTypeListAction action = new GetFileTypeListAction();
    _sm.setAttribute(IAttributeKeys.SESSION_ID, _sessionID);
    _sm.setAttribute(IAttributeKeys.USER_ID, _userID);

    action.init(_sm);
    action.doStart();
    action.validateEvent(event);
    BasicEventResponse response = (BasicEventResponse) action.perform(event);
    action.doEnd();
    return response;
  }

  private void deleteTestData()
  {
    Log.log("TEST", "[GetFileTypeListActionTest.deleteTestData] Enter");

    //find existing acct
    try
    {
      Collection fileTypes = _remote.findFileTypesKeys(_FILTER);
      if (fileTypes != null && !fileTypes.isEmpty())
      {
        for (Iterator i=fileTypes.iterator(); i.hasNext(); )
          _remote.deleteFileType((Long)i.next());
      }
    }
    catch (Exception ex)
    {

    }
    Log.log("TEST", "[GetFileTypeListActionTest.deleteTestData] Exit");
  }

  private void createTestData(String name,
                              String description,
                              String programName,
                              String programPath,
                              String parameters,
                              String workingDir)
  {
    Log.log("TEST", "[GetFileTypeListActionTest.createTestData] Enter");

    _fileType = new FileType();
    _fileType.setName(name);
    _fileType.setDescription(description);
    _fileType.setProgramName(programName);
    _fileType.setProgramPath(programPath);
    _fileType.setParameters(parameters);
    _fileType.setWorkingDirectory(workingDir);

    try
    {
      _remote.createFileType(_fileType);
    }
    catch (Exception ex)
    {
      Log.err("TEST", "GetFileTypeListActionTest.createTestData]", ex);
      assertTrue("Error in createTestData", false);
    }
    Log.log("TEST", "[GetFileTypeListActionTest.createTestData] Exit");
  }

  private Collection findFileTypesKeys(IDataFilter filter)
  {
    Log.log("TEST", "[GetFileTypeListActionTest.findFileTypes] Enter");

    Collection keys = null;
    try
    {
      keys = _remote.findFileTypesKeys(filter);
    }
    catch (Exception ex)
    {
      Log.err("TEST", "[GetFileTypeListActionTest.findFileTypes]", ex);
      assertTrue("Error in remote.findFileTypes", false);
    }

    Log.log("TEST", "[GetUserAccountListActionTest.findUserAccountKeys] Exit");
    return keys;
  }

  /**
   * This simulates performing with a Null event input. This should give a
   * System type error in the event response.
   */
  public void testNullGetEvent() throws Exception
  {
    Log.log("TEST", "[GetFileTypeListActionTest.testNullGetEvent] Enter ");

    try
    {
      _response = performEvent(null);
    }
    catch (EventException ex)
    {
      Log.log("TEST", "[GetFileTypeListActionTest.testNullGetEvent]" +
        " Returning fail due to EventException: "+ex.getMessage());
      Log.log("TEST", "[GetUserAcccountListActionTest.testNullGetEvent] Exit ");
      return;
    }
    catch (Exception ex)
    {
      Log.err("TEST", "[GetUserAccountListActionTeset.testNullGetEvent] Error Exit ", ex);
      assertTrue("Event Exception", false);
    }

    //check response
    assertNotNull("response is null", _response);
    assertTrue("event status is incorrect", !_response.isEventSuccessful());
    assertEquals("Msg code incorrect", IErrorCode.FIND_ENTITY_LIST_ERROR, _response.getMessageCode());
    assertNotNull("Error reason is null", _response.getErrorReason());
    assertNotNull("Error trace is null", _response.getErrorTrace());
    assertEquals("error type is incorrect", _response.getErrorType(), SystemException.SYSTEM);
    Log.log("TEST", "[GetFileTypeListActionTest.testNullGetEvent] Exit ");
  }

  /**
   * This simulates retrieving a list of user accounts with a retrieval condition
   * but no limiting number of rows to return. This should return all the records
   * that fit the retrieval condition.
   */
  public void testGetWithNoLimit() throws Exception
  {
    Log.log("TEST", "[GetFileTypeListActionTest.testGetWithNoLimit] Enter ");

//    for (int i=0; i<LIST_COUNT; i++)
//      createTestData(_FILE_TYPE+i, _DESCRIPTION+i);

    Long[] uIDs = (Long[])findFileTypesKeys(_FILTER).toArray(new Long[_LIST_COUNT]);

    _event = createTestEvent(_FILTER);
    try
    {
      _response = performEvent(_event);
    }
    catch (Exception ex)
    {
      Log.err("TEST", "[GetUserAccountListActionTeset.testGetWithNoLimit] Error Exit ", ex);
      assertTrue("Event Exception", false);
    }

    //check response
    assertNotNull("response is null", _response);
    assertTrue("event is not successful", _response.isEventSuccessful());
    assertEquals("Msg code incorrect", IErrorCode.NO_ERROR, _response.getMessageCode());

    Object returnData = _response.getReturnData();
    assertNotNull("responsedata is null", returnData);
    assertTrue("response data type incorrect", returnData instanceof EntityListResponseData);

    EntityListResponseData listData = (EntityListResponseData)returnData;

    assertEquals("Rows remaining is incorrect", 0, listData.getRowsRemaining());
    assertEquals("start row is incorrect", 0, listData.getStartRow());
    assertNotNull("List ID is null", listData.getListID());

    Collection entityList = listData.getEntityList();
    assertNotNull("Entity list is null", entityList);
    assertEquals("Entity list count is incorrect", _LIST_COUNT, entityList.size());

    Object[] entityObjs = entityList.toArray();
    for (int i=0; i<_LIST_COUNT; i++ )
    {
      assertNotNull("Entity is null", entityObjs[i]);
      assertTrue("Entity is not Map", entityObjs[i] instanceof Map);

      Map fileTypeMap = (Map)entityObjs[i];

      assertEquals("UID is incorrect", uIDs[i], fileTypeMap.get(IFileType.UID));
      assertEquals("FileType incorrect", _FILE_TYPE+i, fileTypeMap.get(IFileType.FILE_TYPE));
      assertEquals("Description incorrect", _DESCRIPTION+i, fileTypeMap.get(IFileType.DESCRIPTION));
      assertEquals("ProgramName is incorrect", _PROGRAM_NAME+i, fileTypeMap.get(IFileType.PROGRAM_NAME));
      assertEquals("ProgramPath is incorrect", _PROGRAM_PATH+i, fileTypeMap.get(IFileType.PROGRAM_PATH));
      assertEquals("Parameters is incorrect", _PARAMETERS+i, fileTypeMap.get(IFileType.PARAMETERS));
      assertEquals("WorkingDirectory is incorrect", _WORKING_DIR+i, fileTypeMap.get(IFileType.WORKING_DIR));
    }
    Log.log("TEST", "[GetFileTypeListActionTest.testGetWithNoLimit] Exit ");
  }

  /**
   * This simulates retrieving a list of user accounts with a retrieval condition
   * and a maximum number of rows to return. This should return the first n number
   * of rows that satisfy the retrieval condition, where n <= max rows.
   */
  public void testGetWithLimit() throws Exception
  {
    Log.log("TEST", "[GetFileTypeListActionTest.testGetWithLimit] Enter ");

//    for (int i=0; i<LIST_COUNT; i++)
//      createTestData(_FILE_TYPE+i, _DESCRIPTION+i);

    Long[] uIDs = (Long[])findFileTypesKeys(_FILTER).toArray(new Long[_LIST_COUNT]);

    _event = createTestEvent(_FILTER, _MAX_PAGE_ENTRIES);
    try
    {
      _response = performEvent(_event);
    }
    catch (Exception ex)
    {
      Log.err("TEST", "[GetUserAccountListActionTeset.testGetWithLimit] Error Exit ", ex);
      assertTrue("Event Exception", false);
    }

    //check response
    assertNotNull("response is null", _response);
    assertTrue("event is not successful", _response.isEventSuccessful());
    assertEquals("Msg code incorrect", IErrorCode.NO_ERROR, _response.getMessageCode());

    Object returnData = _response.getReturnData();
    assertNotNull("responsedata is null", returnData);
    assertTrue("response data type incorrect", returnData instanceof EntityListResponseData);

    EntityListResponseData listData = (EntityListResponseData)returnData;

    assertEquals("Rows remaining is incorrect", _LIST_COUNT-_MAX_PAGE_ENTRIES, listData.getRowsRemaining());
    assertEquals("start row is incorrect", 0, listData.getStartRow());
    assertNotNull("List ID is null", listData.getListID());

    Collection entityList = listData.getEntityList();
    assertNotNull("Entity list is null", entityList);
    assertEquals("Entity list count is incorrect", _MAX_PAGE_ENTRIES, entityList.size());

    Object[] entityObjs = entityList.toArray();
    for (int i=0; i<_MAX_PAGE_ENTRIES; i++ )
    {
      assertNotNull("Entity is null", entityObjs[i]);
      assertTrue("Entity is not Map", entityObjs[i] instanceof Map);

      Map fileTypeMap = (Map)entityObjs[i];

      assertEquals("UID is incorrect", uIDs[i], fileTypeMap.get(IFileType.UID));
      assertEquals("FileType incorrect", _FILE_TYPE+i, fileTypeMap.get(IFileType.FILE_TYPE));
      assertEquals("Description incorrect", _DESCRIPTION+i, fileTypeMap.get(IFileType.DESCRIPTION));
      assertEquals("ProgramName is incorrect", _PROGRAM_NAME+i, fileTypeMap.get(IFileType.PROGRAM_NAME));
      assertEquals("ProgramPath is incorrect", _PROGRAM_PATH+i, fileTypeMap.get(IFileType.PROGRAM_PATH));
      assertEquals("Parameters is incorrect", _PARAMETERS+i, fileTypeMap.get(IFileType.PARAMETERS));
      assertEquals("WorkingDirectory is incorrect", _WORKING_DIR+i, fileTypeMap.get(IFileType.WORKING_DIR));
    }
    Log.log("TEST", "[GetFileTypeListActionTest.testGetWithLimit] Exit ");
  }

  /**
   * This simulates retrieving a list of accounts with a retrieval condition,
   * specifying the maximum number of rows to return, and the starting row from
   * which list to return the results. This should return Row(i) - Row(m) user
   * accounts that satisfy that retrieval conditions, i = start row, m=n-i+1
   * and n <= max rows.
   */
  public void testGetStartWithLimit() throws Exception
  {
    Log.log("TEST", "[GetFileTypeListActionTest.testGetStartWithLimit] Enter ");

//    for (int i=0; i<LIST_COUNT; i++)
//      createTestData(_FILE_TYPE+i, _DESCRIPTION+i);

    Long[] uIDs = (Long[])findFileTypesKeys(_FILTER).toArray(new Long[_LIST_COUNT]);

    _event = createTestEvent(_FILTER, _MAX_PAGE_ENTRIES, _START_ROW);
    try
    {
      _response = performEvent(_event);
    }
    catch (Exception ex)
    {
      Log.err("TEST", "[GetFileTypeListActionTest.testGetStartWithLimit] Error Exit ", ex);
      assertTrue("Event Exception", false);
    }

    //check response
    assertNotNull("response is null", _response);
    assertTrue("event is not successful", _response.isEventSuccessful());
    assertEquals("Msg code incorrect", IErrorCode.NO_ERROR, _response.getMessageCode());

    Object returnData = _response.getReturnData();
    assertNotNull("responsedata is null", returnData);
    assertTrue("response data type incorrect", returnData instanceof EntityListResponseData);

    EntityListResponseData listData = (EntityListResponseData)returnData;

    assertEquals("Rows remaining is incorrect",
      _MAX_PAGE_ENTRIES+_START_ROW>_LIST_COUNT? 0 : _LIST_COUNT-_MAX_PAGE_ENTRIES-_START_ROW, listData.getRowsRemaining());
    assertEquals("start row is incorrect", _START_ROW, listData.getStartRow());
    assertNotNull("List ID is null", listData.getListID());

    Collection entityList = listData.getEntityList();
    assertNotNull("Entity list is null", entityList);
    assertEquals("Entity list count is incorrect",
      _LIST_COUNT-_START_ROW<_MAX_PAGE_ENTRIES?_LIST_COUNT-_START_ROW:_MAX_PAGE_ENTRIES, entityList.size());

    Object[] entityObjs = entityList.toArray();
    for (int i=0; i<entityObjs.length; i++ )
    {
      assertNotNull("Entity is null", entityObjs[i]);
      assertTrue("Entity is not Map", entityObjs[i] instanceof Map);

      Map fileTypeMap = (Map)entityObjs[i];

      assertEquals("UID is incorrect", uIDs[i+_START_ROW], fileTypeMap.get(IFileType.UID));
      assertEquals("FileType incorrect", _FILE_TYPE+(i+_START_ROW), fileTypeMap.get(IFileType.FILE_TYPE));
      assertEquals("Description incorrect", _DESCRIPTION+(i+_START_ROW), fileTypeMap.get(IFileType.DESCRIPTION));
      assertEquals("ProgramName is incorrect", _PROGRAM_NAME+(i+_START_ROW), fileTypeMap.get(IFileType.PROGRAM_NAME));
      assertEquals("ProgramPath is incorrect", _PROGRAM_PATH+(i+_START_ROW), fileTypeMap.get(IFileType.PROGRAM_PATH));
      assertEquals("Parameters is incorrect", _PARAMETERS+(i+_START_ROW), fileTypeMap.get(IFileType.PARAMETERS));
      assertEquals("WorkingDirectory is incorrect", _WORKING_DIR+(i+_START_ROW), fileTypeMap.get(IFileType.WORKING_DIR));
    }
    Log.log("TEST", "[GetFileTypeListActionTest.testGetStartWithLimit] Exit ");
  }

  /**
   * This simulates retrieving list of user accounts with a retrieval condition
   * through several event calls. Each event call should return a List ID which
   * can be used in subsequent calls to retrieve the entire list, page by page.
   *
   * @since 2.0
   */
  public void testGetWithCursor() throws Exception
  {
    Log.log("TEST", "[GetFileTypeListActionTest.testGetWithCursor] Enter ");

//    for (int i=0; i<LIST_COUNT; i++)
//      createTestData(_FILE_TYPE+i, _DESCRIPTION+i);

    Long[] uIDs = (Long[])findFileTypesKeys(_FILTER).toArray(new Long[_LIST_COUNT]);
    int numPages = (int)java.lang.Math.ceil((double)_LIST_COUNT / (double)_MAX_PAGE_ENTRIES);
    Log.debug("TEST", "Number of Pages: "+numPages);

    _event = createTestEvent(_FILTER, _MAX_PAGE_ENTRIES, 0);

    for (int j=0; j<numPages; j++)
    {
      try
      {
        _response = performEvent(_event);
      }
      catch (Exception ex)
      {
        Log.err("TEST", "[GetFileTypeListActionTest.testGetWithCursor] Error Exit ", ex);
        assertTrue("Event Exception", false);
      }

      //check response
      assertNotNull("response is null", _response);
      assertTrue("event is not successful", _response.isEventSuccessful());
      assertEquals("Msg code incorrect", IErrorCode.NO_ERROR, _response.getMessageCode());

      Object returnData = _response.getReturnData();
      assertNotNull("responsedata is null", returnData);
      assertTrue("response data type incorrect", returnData instanceof EntityListResponseData);

      EntityListResponseData listData = (EntityListResponseData)returnData;

      boolean lastPage = (j+1 == numPages);
      int startRow = (_MAX_PAGE_ENTRIES*j);

      assertEquals("Rows remaining is incorrect",
        lastPage? 0 : _LIST_COUNT-startRow-_MAX_PAGE_ENTRIES, listData.getRowsRemaining());
      assertEquals("start row is incorrect", startRow, listData.getStartRow());
      assertNotNull("List ID is null", listData.getListID());

      Collection entityList = listData.getEntityList();
      assertNotNull("Entity list is null", entityList);
      assertEquals("Entity list count is incorrect",
        _LIST_COUNT-startRow<_MAX_PAGE_ENTRIES?_LIST_COUNT-startRow:_MAX_PAGE_ENTRIES, entityList.size());

      Object[] entityObjs = entityList.toArray();
      for (int i=0; i<entityObjs.length; i++ )
      {
        assertNotNull("Entity is null", entityObjs[i]);
        assertTrue("Entity is not Map", entityObjs[i] instanceof Map);

        Map fileTypeMap = (Map)entityObjs[i];

        assertEquals("UID is incorrect", uIDs[i+startRow], fileTypeMap.get(IFileType.UID));
        assertEquals("FileType incorrect", _FILE_TYPE+(i+startRow), fileTypeMap.get(IFileType.FILE_TYPE));
        assertEquals("Description incorrect", _DESCRIPTION+(i+startRow), fileTypeMap.get(IFileType.DESCRIPTION));
        assertEquals("ProgramName is incorrect", _PROGRAM_NAME+(i+startRow), fileTypeMap.get(IFileType.PROGRAM_NAME));
        assertEquals("ProgramPath is incorrect", _PROGRAM_PATH+(i+startRow), fileTypeMap.get(IFileType.PROGRAM_PATH));
        assertEquals("Parameters is incorrect", _PARAMETERS+(i+startRow), fileTypeMap.get(IFileType.PARAMETERS));
        assertEquals("WorkingDirectory is incorrect", _WORKING_DIR+(i+startRow), fileTypeMap.get(IFileType.WORKING_DIR));
      }

      _event = createTestEvent(listData.getListID(), _MAX_PAGE_ENTRIES, startRow+_MAX_PAGE_ENTRIES);
    }
    Log.log("TEST", "[GetFileTypeListActionTest.testGetWithCursor] Exit ");
  }
}