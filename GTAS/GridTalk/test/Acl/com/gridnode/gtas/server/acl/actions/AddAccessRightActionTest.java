/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: AddAccessRightActionTest.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * Jun 07 2002    Neo Sok Lay         Created
 */
package com.gridnode.gtas.server.acl.actions;

import com.gridnode.pdip.framework.exceptions.ApplicationException;
import com.gridnode.pdip.framework.rpf.event.BasicEventResponse;
import com.gridnode.pdip.framework.rpf.event.IEvent;
import com.gridnode.pdip.framework.rpf.event.EventException;
import com.gridnode.pdip.framework.rpf.ejb.StateMachine;
import com.gridnode.pdip.framework.rpf.ejb.action.IEJBAction;
import com.gridnode.pdip.framework.util.ServiceLocator;
import com.gridnode.pdip.framework.util.PasswordMask;
import com.gridnode.pdip.framework.db.filter.IDataFilter;
import com.gridnode.pdip.framework.db.filter.DataFilterImpl;

import com.gridnode.pdip.base.acl.facade.ejb.IACLManagerHome;
import com.gridnode.pdip.base.acl.facade.ejb.IACLManagerObj;
import com.gridnode.pdip.base.acl.model.Role;
import com.gridnode.pdip.base.acl.model.AccessRight;
import com.gridnode.pdip.base.acl.model.Feature;

import com.gridnode.pdip.app.user.facade.ejb.IUserManagerHome;
import com.gridnode.pdip.app.user.facade.ejb.IUserManagerObj;
import com.gridnode.pdip.app.user.model.UserAccount;

import com.gridnode.pdip.base.session.facade.ejb.ISessionManagerHome;
import com.gridnode.pdip.base.session.facade.ejb.ISessionManagerObj;

import com.gridnode.gtas.events.acl.AddAccessRightEvent;
import com.gridnode.gtas.exceptions.IErrorCode;
import com.gridnode.gtas.server.acl.helpers.ACLLogger;
import com.gridnode.gtas.server.rdm.IAttributeKeys;

import junit.framework.*;

import java.util.Collection;
import java.util.ArrayList;

/**
 * This test case tests the functionality of the AddAccessRightAction class.
 *
 * @author Neo Sok Lay
 *
 * @version 2.0
 * @since 2.0
 */
public class AddAccessRightActionTest extends TestCase
{
  private static final String CLASSNAME = "AddAccessRightActionTest";

  private static final String ROLE_NAME_1 = "Role Name 1";
  private static final String DESCRIPTION_1 = "Description 1";

  private static final String ROLE_NAME_2 = "Role Name 2";
  private static final String DESCRIPTION_2 = "Description 2";

  private static final Long ROLE_UID_DUMMY = new Long(-9999);
  private static final String FEATURE_DUMMY = "RUBBISH";
  private static final String ACTION_DUMMY  = "RUBBISH";
  private static final String DATA_TYPE_DUMMY = "RUBBISH";

  private static final String FEATURE_1     = "Test Feature 1";
  private static final String DESC_1        = "Test Description 1";
  private static final String ACTION_1      = "Test Action 1";
  private static final String DATA_TYPE_1   = "Test Data Type 1";
  private static final IDataFilter CRITERIA_1 = null;

  private static final String FEATURE_2     = "Test Feature 2";
  private static final String DESC_2        = "Test Description 2";
  private static final String ACTION_2      = "Test Action 2";
  private static final String DATA_TYPE_2   = "Test Data Type 2";
  private static final IDataFilter CRITERIA_2 = new DataFilterImpl();

  private static final String DATA_TYPE_3   = "Test Data Type 3";

  //for domain type filter
  private static final String CRI_FIELD_ID_1 = "TEST_FIELD_ID_1";
  private static final Collection CRI_LIST_1 = new ArrayList();
  private static final String CRI_VALUE_1_1 = "TEST_VALUE_1_1";
  private static final String CRI_VALUE_1_2 = "TEST_VALUE_1_2";
  private static final String CRI_VALUE_1_3 = "TEST_VALUE_1_3";

  //for range type filter
  private static final String CRI_FIELD_ID_2 = "TEST_FIELD_ID_2";
  private static final Integer CRI_VALUE_2_1 = new Integer(1);
  private static final Long CRI_VALUE_2_2    = new Long(999999);

  //for single type filter
  private static final String CRI_FIELD_ID_3 = "TEST_FIELD_ID_3";
  private static final Boolean CRI_VALUE_3   = Boolean.TRUE;

  private static final ArrayList ACTION_LIST = new ArrayList();
  private static final ArrayList DATATYPE_LIST = new ArrayList();

  static
  {
    CRI_LIST_1.add(CRI_FIELD_ID_1);
    CRI_LIST_1.add(CRI_FIELD_ID_2);
    CRI_LIST_1.add(CRI_FIELD_ID_3);

    CRITERIA_2.addDomainFilter(null, CRI_FIELD_ID_1, CRI_LIST_1, false);

    CRITERIA_2.addRangeFilter(CRITERIA_2.getAndConnector(),
      CRI_FIELD_ID_2, CRI_VALUE_2_1, CRI_VALUE_2_2, false);

    CRITERIA_2.addSingleFilter(CRITERIA_2.getOrConnector(),
      CRI_FIELD_ID_3, CRITERIA_2.getEqualOperator(), CRI_VALUE_3, true);

    ACTION_LIST.add(ACTION_1);
    ACTION_LIST.add(ACTION_2);

    DATATYPE_LIST.add(DATA_TYPE_1);
    DATATYPE_LIST.add(DATA_TYPE_2);
    DATATYPE_LIST.add(DATA_TYPE_3);
  }

  IACLManagerHome     _aclHome;
  IACLManagerObj      _aclMgr;
  IUserManagerHome    _userHome;
  IUserManagerObj     _userMgr;
  ISessionManagerHome _sessionHome;
  ISessionManagerObj  _sessionMgr;

  ArrayList             _openedSessions = new ArrayList();
  AddAccessRightEvent[] _events;
  StateMachine[]        _sm;
  String[]              _sessions;
  DataFilterImpl[]      _filters;
  AccessRight[]         _mockAcrs;

  private Long ROLE_UID_1;
  private Long ROLE_UID_2;


  public AddAccessRightActionTest(String name)
  {
    super(name);
  }

  public static Test suite()
  {
    return new TestSuite(AddAccessRightActionTest.class);
  }

  public static void main(String args[])
  {
    junit.textui.TestRunner.run(suite());
  }

  protected void setUp() throws Exception
  {
    try
    {
      ACLLogger.infoLog(CLASSNAME, "setUp", "Enter");

      lookupACLManager();
      lookupSessionManager();
      lookupUserManager();
      cleanup();
    }
    finally
    {
      ACLLogger.infoLog(CLASSNAME, "setUp", "Exit");
    }
  }

  protected void tearDown() throws Exception
  {
    ACLLogger.infoLog(CLASSNAME, "tearDown", "Enter");
    cleanup();
    ACLLogger.infoLog(CLASSNAME, "tearDown", "Exit");
  }

  public void testPerform() throws Exception
  {
   try
    {
      ACLLogger.infoLog(CLASSNAME, "testPerform", "Enter");

      prepareTestData();
      addRejectedByAction();
      addAcceptedByManager();
      addRejectedByManager();
      cleanupTestData();

    }
    finally
    {
      ACLLogger.infoLog(CLASSNAME, "testPerform", "Exit");
    }
  }


  private void addRejectedByAction() throws Exception
  {
    // **  REJECTED BY ACTION

    // null event.
    checkAddAccessRightFail(null, _sessions[0], _sm[0], true);

    // invalid session id
    checkAddAccessRightFail(_events[0], "AAA", _sm[0], true);

    // not auth session
    checkAddAccessRightFail(_events[0], _sessions[1], _sm[0], true);

    // invalid auth subject (session name)
    checkAddAccessRightFail(_events[0], _sessions[0], _sm[1], true);

    // non existing Role
    checkAddAccessRightFail(_events[1], _sessions[0], _sm[0], true);

    // non existing feature
    checkAddAccessRightFail(_events[2], _sessions[0], _sm[0], true);

    // non existing action
    checkAddAccessRightFail(_events[3], _sessions[0], _sm[0], true);

    // non existing data type
    checkAddAccessRightFail(_events[4], _sessions[0], _sm[0], true);
  }

  private void addAcceptedByManager() throws Exception
  {
    // *** ACCEPTED BY Manager
    // test create with no data type
    checkAddAccessRightSuccess(_events[5], _sessions[0], _sm[0], _filters[0], _mockAcrs[0]);

    // test create with data type
    checkAddAccessRightSuccess(_events[6], _sessions[0], _sm[0], _filters[1], _mockAcrs[1]);

    // test create with data type, criteria
    checkAddAccessRightSuccess(_events[7], _sessions[0], _sm[0], _filters[2], _mockAcrs[2]);

    // test create with different data type
    checkAddAccessRightSuccess(_events[8], _sessions[0], _sm[0], _filters[3], _mockAcrs[3]);
  }

  private void addRejectedByManager() throws Exception
  {
    // *** REJECTED BY Manager
    // test create duplicate
    checkAddAccessRightFail(_events[9], _sessions[0], _sm[0], false);

    // test create duplicate with null data type
    checkAddAccessRightFail(_events[10], _sessions[0], _sm[0], false);

    // test create duplicate with same data type
    checkAddAccessRightFail(_events[11], _sessions[0], _sm[0], false);

    // test create duplicate with non-null data type
    checkAddAccessRightFail(_events[12], _sessions[0], _sm[0], false);

  }

  private void checkAddAccessRightSuccess(
    IEvent event, String session, StateMachine sm,
    DataFilterImpl filter, AccessRight mock)
  {
    BasicEventResponse response = null;
    try
    {
      response = performEvent(new AddAccessRightAction(), event, session, sm);
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "checkAddAccessRightSuccess", "Error Exit", ex);
      assertTrue("Event Exception", false);
    }
    assertNotNull("Response is null", response);
    assertTrue("Event status is incorrect", response.isEventSuccessful());
    assertEquals("Msg code incorrect", response.getMessageCode(), IErrorCode.NO_ERROR);
    assertNull("Error reason is not null", response.getErrorReason());
    assertNull("Error trace is not null", response.getErrorTrace());
    assertEquals("error type is not null", response.getErrorType(), -1);

    checkAccessRight(filter, mock);
  }

  private void checkAccessRight(DataFilterImpl filter, AccessRight mock)
  {
    AccessRight saved = getAccessRight(filter);
    assertNotNull("Access right not retrieved", saved);

    assertEquals("Action is different", saved.getAction(), mock.getAction());
    if (saved.getCriteria() == null)
      assertNull("Criteria should be null", mock.getCriteria());
    else
    {
      assertNotNull("Criteria should not be null", mock.getCriteria());
      assertEquals("Critieria is different", saved.getCriteria().getFilterExpr(), mock.getCriteria().getFilterExpr());
    }
    assertEquals("Data type is different", saved.getDataType(), mock.getDataType());
    assertEquals("Description is different", saved.getDescr(), mock.getDescr());
    assertEquals("Feature is different", saved.getFeature(), mock.getFeature());
    assertEquals("Role is different", saved.getRoleUID(), mock.getRoleUID());
  }

  private void checkAddAccessRightFail(
    IEvent event, String session, StateMachine sm, boolean eventEx)
  {
    BasicEventResponse response = null;
    try
    {
      response = performEvent(new AddAccessRightAction(), event, session, sm);
    }
    catch (EventException ex)
    {
      ACLLogger.infoLog(CLASSNAME, "checkAddAccessRightFail", "Fail due to event exception: "+ex.getMessage());
      if (!eventEx)
        assertTrue("Unexpected Event Exception", false);
      ACLLogger.infoLog(CLASSNAME, "checkAddAccessRightFail", "Exit");
      return;
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "checkAddAccessRightFail", "Error Exit", ex);
      assertTrue("Event Exception", false);
    }
    assertNotNull("Response is null", response);
    assertTrue("Event status is incorrect", !response.isEventSuccessful());
    assertEquals("Msg code incorrect", IErrorCode.CREATE_ENTITY_ERROR, response.getMessageCode());
    assertNotNull("Error reason is null", response.getErrorReason());
    assertEquals("error type is incorrect", response.getErrorType(), ApplicationException.APPLICATION);
  }

  // ************************ Utility Methods *********************

  private void lookupACLManager() throws Exception
  {
    _aclHome = (IACLManagerHome)ServiceLocator.instance(
             ServiceLocator.CLIENT_CONTEXT).getHome(
             IACLManagerHome.class.getName(),
             IACLManagerHome.class);
    assertNotNull("aclHome is null", _aclHome);
    _aclMgr = _aclHome.create();
    assertNotNull("aclMgr is null", _aclMgr);
  }

  private void lookupUserManager() throws Exception
  {
    _userHome = (IUserManagerHome)ServiceLocator.instance(
             ServiceLocator.CLIENT_CONTEXT).getHome(
             IUserManagerHome.class.getName(),
             IUserManagerHome.class);
    assertNotNull("userHome is null", _userHome);
    _userMgr = _userHome.create();
    assertNotNull("userMgr is null", _userMgr);
  }

  private void lookupSessionManager() throws Exception
  {
    _sessionHome = (ISessionManagerHome)ServiceLocator.instance(
             ServiceLocator.CLIENT_CONTEXT).getHome(
             ISessionManagerHome.class.getName(),
             ISessionManagerHome.class);
    assertNotNull("sessionHome is null", _sessionHome);
    _sessionMgr = _sessionHome.create();
    assertNotNull("sessionMgr is null", _sessionMgr);
  }

  private void prepareTestData() throws Exception
  {
    createTestRoles();
    createTestFeatures();

    _sm = new StateMachine[]
    {
      new StateMachine(null, null),
      new StateMachine(null, null),
    };

    _sessions = new String[]
    {
      openSession("TEST_USER"),
      openSession(null),
    };

    _sm[0].setAttribute(IAttributeKeys.USER_ID, "TEST_USER");
    _sm[1].setAttribute(IAttributeKeys.USER_ID, "RUBBISH");

    _events = new AddAccessRightEvent[]
    {
      //0-4 used in addRejectedByAction
      createEvent(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_1),
      createEvent(DESC_1, ROLE_UID_DUMMY, FEATURE_1, ACTION_1),
      createEvent(DESC_1, ROLE_UID_1, FEATURE_DUMMY, ACTION_1),
      createEvent(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_DUMMY),
      createEvent(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_2, DATA_TYPE_DUMMY, CRITERIA_1),

      //5-8 used in addAcceptedByManager
      createEvent(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_1),
      createEvent(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_1, DATA_TYPE_1, null),
      createEvent(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_2, DATA_TYPE_2, CRITERIA_2),
      createEvent(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_2, DATA_TYPE_1, CRITERIA_2),

      //9-12 used in addRejectedByManager
      createEvent(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_1),
      createEvent(DESC_1, ROLE_UID_2, FEATURE_1, ACTION_1),
      createEvent(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_1, DATA_TYPE_1, CRITERIA_2),
      createEvent(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_1, DATA_TYPE_1, CRITERIA_1),
    };

    _mockAcrs = new AccessRight[]
    {
      createMockAccessRight(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_1, null, null),
      createMockAccessRight(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_1, DATA_TYPE_1, null),
      createMockAccessRight(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_2, DATA_TYPE_2, CRITERIA_2),
      createMockAccessRight(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_2, DATA_TYPE_1, CRITERIA_2),
    };

    _filters = new DataFilterImpl[]
    {
      createFilter(DESC_1, ROLE_UID_1, FEATURE_1, ACTION_1, null),
      createFilter(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_1, DATA_TYPE_1),
      createFilter(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_2, DATA_TYPE_2),
      createFilter(DESC_2, ROLE_UID_2, FEATURE_1, ACTION_2, DATA_TYPE_1),
    };
  }

  private AccessRight createMockAccessRight(
    String description, Long roleUId, String feature,
    String grantedAction, String grantedDataType, IDataFilter grantCriteria)
  {
    AccessRight acr = new AccessRight();
    acr.setAction(grantedAction);
    acr.setCriteria(grantCriteria);
    acr.setDataType(grantedDataType);
    acr.setDescr(description);
    acr.setFeature(feature);
    acr.setRoleUID(roleUId);

    return acr;
  }

  private DataFilterImpl createFilter(
    String description, Long roleUId, String feature,
    String grantedAction, String grantedDataType)
  {
    DataFilterImpl filter = new DataFilterImpl();
    filter.addSingleFilter(null, AccessRight.DESCRIPTION, filter.getEqualOperator(),
      description, false);
    filter.addSingleFilter(filter.getAndConnector(), AccessRight.ROLE,
      filter.getEqualOperator(), roleUId, false);
    filter.addSingleFilter(filter.getAndConnector(), AccessRight.FEATURE,
      filter.getEqualOperator(), feature, false);
    filter.addSingleFilter(filter.getAndConnector(), AccessRight.ACTION,
      filter.getEqualOperator(), grantedAction, false);
    filter.addSingleFilter(filter.getAndConnector(), AccessRight.DATA_TYPE,
      filter.getEqualOperator(), grantedDataType, false);

    return filter;
  }

  private void createTestRoles()
  {
    createTestRole(ROLE_NAME_1, DESCRIPTION_1);
    createTestRole(ROLE_NAME_2, DESCRIPTION_2);
    Role role = getTestRole(ROLE_NAME_1);
    ROLE_UID_1 = new Long(role.getUId());

    role = getTestRole(ROLE_NAME_2);
    ROLE_UID_2 = new Long(role.getUId());
  }

  private void createTestFeatures()
  {
    createTestFeature(FEATURE_1, DESCRIPTION_1, ACTION_LIST, DATATYPE_LIST);
    createTestFeature(FEATURE_2, DESCRIPTION_2, ACTION_LIST, DATATYPE_LIST);
  }

  private void cleanupTestData()
  {
    try
    {
      closeAllSessions();
    }
    catch (Exception ex)
    {
    }
  }

  private void cleanup()
  {
    deleteTestRole(ROLE_NAME_1);
    deleteTestRole(ROLE_NAME_2);
    deleteTestFeature(FEATURE_1);
    deleteTestFeature(FEATURE_2);
  }

  private void deleteTestRole(String roleName)
  {
    try
    {
      Role deleted = getTestRole(roleName);
      if (deleted != null)
         _aclMgr.deleteRole(new Long(deleted.getUId()));
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "deleteTestRole", "Unable to delete test data with rolename = "
                                    + roleName, ex);
    }
  }

  private Role getTestRole(String roleName)
  {
    try
    {
      return _aclMgr.getRoleByRoleName(roleName);
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "getTestRole", "Unable to retrieve test data with rolename = "
                                    + roleName, ex);
      return null;
    }
  }

  private void createTestRole(String roleName, String description)
  {
    Role role = new Role();
    role.setDescr(description);
    role.setRole(roleName);

    try
    {
      _aclMgr.createRole(role);
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "createTestRole", "Error creating role with rolename = "
                                    + roleName, ex);
      assertTrue("Error in createTestRole", false);
    }
  }


  private void createTestFeature(
    String featureName, String description, ArrayList actionList, ArrayList dataTypeList)
  {
    Feature feature = new Feature();

    feature.setActions(actionList);
    feature.setDataTypes(dataTypeList);
    feature.setDescr(description);
    feature.setFeature(featureName);

    try
    {
      _aclMgr.createFeature(feature);
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "createTestFeature", "Error creating feature:"
        + featureName, ex);
      assertTrue("Error in createTestFeature", false);
    }
  }

  private void deleteTestFeature(String featureName)
  {
    try
    {
      Feature deleted = getTestFeature(featureName);
      if (deleted != null)
         _aclMgr.deleteFeature(new Long(deleted.getUId()));
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "deleteTestFeature", "Unable to delete test feature: "
                                    + featureName, ex);
    }
  }

  private Feature getTestFeature(String featureName)
  {
    try
    {
      return _aclMgr.getFeatureByFeatureName(featureName);
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "getTestFeature", "Unable to retrieve test feature: "
                                    + featureName, ex);
      return null;
    }
  }

  private AccessRight getAccessRight(DataFilterImpl filter)
  {
    try
    {
      Collection acrList = _aclMgr.getAccessRights(filter);
      if (acrList.isEmpty())
        return null;
      else
        return (AccessRight)acrList.iterator().next();
    }
    catch (Exception ex)
    {
      ACLLogger.errorLog(CLASSNAME, "getTestAcr", "Unable to retrieve test access right with filter: "
                                    + filter.getFilterExpr(), ex);
      return null;
    }
  }

  private BasicEventResponse performEvent(
    IEJBAction action,
    IEvent event, String session, StateMachine sm)
    throws Exception
  {
    sm.setAttribute(IAttributeKeys.SESSION_ID, session);

    action.init(sm);
    action.doStart();
    action.validateEvent(event);
    BasicEventResponse response = (BasicEventResponse) action.perform(event);
    action.doEnd();
    return response;
  }

  private AddAccessRightEvent createEvent(
    String description, Long roleUId, String feature,
    String grantedAction)
    throws Exception
  {
    return new AddAccessRightEvent(description, roleUId, feature, grantedAction);
  }

  private AddAccessRightEvent createEvent(
    String description, Long roleUId, String feature,
    String grantedAction, String grantedDataType, IDataFilter grantCriteria)
    throws Exception
  {
    return new AddAccessRightEvent(description, roleUId, feature, grantedAction,
               grantedDataType, grantCriteria);
  }

  private String openSession(String sessionName) throws Exception
  {
    String sessionID = _sessionMgr.openSession();
    if (sessionName != null)
    {
      _sessionMgr.authSession(sessionID, sessionName);
    }
    return sessionID;
  }

  private void closeSession(String sessionId) throws Exception
  {
    _sessionMgr.closeSession(sessionId);
    _openedSessions.remove(sessionId);
  }

  private void closeAllSessions() throws Exception
  {
    String[] sessions = (String[])_openedSessions.toArray(new String[0]);
    for (int i=0; i<sessions.length; i++)
      closeSession(sessions[i]);
  }
}