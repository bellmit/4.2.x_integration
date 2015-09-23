// %1023962280520:com.gridnode.pdip.app.deployment.bpss%
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
 * Jun 10 2002   Mathew	        Created
 * Jun 13 2002   Mathew         Repackaged
 * Nov 11 2005    Neo Sok Lay         Change to use entityHandler.createEntity
 *                                    to ensure created entity has the correct populated UID
 * Dec 07 2005   Tam Wei Xiang  i)   To remove the depedency on borland xml API.
 *                                   Use GN XML api instead.
 *                              ii)  Change method marshal(), unmarshal(element) to
 *                                   buildElement() and buildModel(element).
 *                              iii) We will use the getParent and setParent method
 *                                   in AbstractBpssModel instead of using XMLObject._getParent
 *                                   and _setParent
 *                              iv)  method validate(boolean) has been removed.     
 */



/**
 * This file is generated by BorlandXML.
 */
package com.gridnode.pdip.app.deploy.manager.bpss;

import java.util.*;

import com.gridnode.pdip.app.deploy.manager.GWFDeployableList;
import com.gridnode.pdip.app.deploy.manager.IGWFDeployable;
import com.gridnode.pdip.app.deploy.manager.util.Utilities;
import com.gridnode.pdip.base.gwfbase.bpss.model.BpssFork;
import com.gridnode.pdip.base.gwfbase.bpss.model.BpssProcessSpecEntry;
import com.gridnode.pdip.framework.db.AbstractEntityHandler;
import com.gridnode.pdip.framework.db.EntityHandlerFactory;
import com.gridnode.pdip.framework.exceptions.domain.GWFException;
import com.gridnode.xml.adapters.GNAttribute;
import com.gridnode.xml.adapters.GNElement;
import com.gridnode.xml.adapters.GNXMLDocumentUtility;

/**
 * The Fork class represents the element "Fork" with the content
 * model defined as follows:
 * <p>
 * &lt;!ELEMENT Fork (Documentation)*&gt;<br>
 */
public class Fork
  extends AbstractBpssModel
  implements IGWFDeployable
{

  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -3836561624431256569L;

	/** xml tag name of this element. */
  public static String _tagName = "Fork";

  /** Defines a name attribute */
  public GNAttribute name  = GNXMLDocumentUtility.newAttribute("name", "");
  
  /** Defines a nameID attribute */
  public GNAttribute nameID = GNXMLDocumentUtility.newAttribute("nameID", "");
  
  
  /** Defines a list of Documentation objects. */
  protected ArrayList _objDocumentation = new ArrayList();

  /**
     * Creates an empty Fork object
     */
  public Fork()
  {
    super();
  }

  /**
     * Gets the value of "name" attribute.
     */
  public String getName()
  {
    return name.getValue();
  }

  /**
     * Replaces the existing attribute value with a new value.
     * @param value    New value.
     */
  public void setName(String value_)
  {
    name.setValue(value_);
  }

  /**
     * Gets the value of "nameID" attribute.
     */
  public String getNameID()
  {
    return nameID.getValue();
  }

  /**
     * Replaces the existing attribute value with a new value.
     * @param value    New value.
     */
  public void setNameID(String value_)
  {
    nameID.setValue(value_);
  }

  /**
     * Returns an array of Documentation objects. The length of the returned
     * array is zero if the list of Documentation object is empty.
     */
  public Documentation[] getDocumentation()
  {
    return (Documentation[])_objDocumentation.toArray(new Documentation[0]);
  }

  /**
     * Replaces all existing Documentation objects with a new array of
     * Documentation objects.
     * @param objArray    an array of Documentation objects.
     */
  public void setDocumentation(Documentation[] objArray)
  {
    if (objArray == null || objArray.length == 0)
      this._objDocumentation.clear();
    else
    {
      this._objDocumentation = new ArrayList(Arrays.asList(objArray));
      for (int i = 0; i < objArray.length; i++)
      {
        if (objArray[i] != null)
          objArray[i].setParent(this);
      }
    }
  }

  /**
     * Gets the Documentation object at the specified index.
     * @param index    index of the returned object.
     * @throws IndexOutOfBoundsException    if index is out of range.
     */
  public Documentation getDocumentation(int index)
  {
    return (Documentation)_objDocumentation.get(index);
  }

  /**
     * Replaces an existing Documentation object at the specified index with
     * a new Documentation object.
     * @param index    index of replaced object.
     * @throws IndexOutOfBoundsException    if index is out of range.
     */
  public void setDocumentation(int index, Documentation obj)
  {
    if (obj == null)
      removeDocumentation(index);
    else
    {
      _objDocumentation.set(index, obj);
      obj.setParent(this);
    }
  }

  /**
     * Returns the number of Documentation objects in the list.
     */
  public int getDocumentationCount()
  {
    return _objDocumentation.size();
  }

  /**
     * Returns <code>true</code> if there is no Documentation object in the list; otherwise,
     * the method returns <code>false</code>.
     */
  public boolean isNoDocumentation()
  {
    return _objDocumentation.size() == 0;
  }

  /**
     * Returns a read-only list of Documentation objects.
     */
  public List getDocumentationList()
  {
    return Collections.unmodifiableList(_objDocumentation);
  }

  /**
     * Adds a new Documentation object at the end of the list.
     * @return <code>true</code> if the new object is added to the list; otherwise,
     * the method returns <code>false</code>.
     */
  public boolean addDocumentation(Documentation obj)
  {
    if (obj == null)
      return false;
    obj.setParent(this);
    return _objDocumentation.add(obj);
  }

  /**
     * Adds a list of new Documentation objects at the end of the list.
     * @return <code>true</code> if the list was changed; otherwise, the method
     * returns <code>false</code>.
     */
  public boolean addDocumentation(Collection coDocumentation)
  {
    if (coDocumentation == null)
      return false;
    java.util.Iterator it = coDocumentation.iterator();
    while (it.hasNext())
    {
      Object obj = it.next();
      if (obj != null && obj instanceof AbstractBpssModel)
        ((AbstractBpssModel)obj).setParent(this);
    }
    return _objDocumentation.addAll(coDocumentation);
  }

  /**
     * Removes an existing Documentation object at the specified index.
     * @return    The removed object.
     */
  public Documentation removeDocumentation(int index)
  {
    return (Documentation)_objDocumentation.remove(index);
  }

  /**
     * Removes the specified Documentation object.
     * @return <code>true</code> if this list contains the object; otherwise,
     * the method returns <code>false</code>.
     */
  public boolean removeDocumentation(Documentation obj)
  {
    return _objDocumentation.remove(obj);
  }

  /**
     * Clears all Documentation objects from the list.
     */
  public void clearDocumentationList()
  {
    _objDocumentation.clear();
  }

  /**
     * Returns a list containing all child elements. Each element in the list is a subclass
     * of XmlObject.
     */
  public java.util.List _getChildren()
  {
    java.util.List children = new java.util.ArrayList();

    /** adds _objDocumentation */
    if (_objDocumentation != null && _objDocumentation.size() > 0)
      children.add(_objDocumentation);
    return children;
  }

  /**
     * Gets the tag name of this element.
     */
  public String get_TagName()
  {
    return _tagName;
  }

  /**
   * DOCUMENT ME!
   * 
   * @param specUId DOCUMENT ME!
   * @param incomplete DOCUMENT ME!
   * @return DOCUMENT ME! 
   * @throws GWFException DOCUMENT ME!
   */
  public int deploy(long specUId, Hashtable incomplete)
             throws GWFException
  {
    GWFDeployableList list = new GWFDeployableList();
    int finalResult = 0;
    if (this.getDocumentationCount() > 0)
    {
      list.addAll(Arrays.asList(this.getDocumentation()));
      finalResult = Utilities.combineResult(GWF_SUCCESS_DIV, 
                                            list.deploy(specUId, incomplete));
    }
    //Deploy attributes to database

    /**
     * TODO: fromAuthorizedRole, fromAuthorizedRoleIDRef, toAuthorizedRole,
     * toAuthorizedRoleIDRef
     */
    BpssFork bpssFork = new BpssFork();
    bpssFork.setRestrictionName(this.getName());
    try
    {
      AbstractEntityHandler handler = EntityHandlerFactory.getHandlerFor(
                                          BpssFork.ENTITY_NAME, true);
      bpssFork = (BpssFork)handler.createEntity(bpssFork);
      BpssProcessSpecEntry bpssProcSpecEntry = new BpssProcessSpecEntry();
      bpssProcSpecEntry.setSpecUId(specUId);
      bpssProcSpecEntry.setEntryName(bpssFork.getRestrictionName());
      bpssProcSpecEntry.setEntryType(bpssFork.getEntityName());
      bpssProcSpecEntry.setEntryUId(bpssFork.getUId());
      handler = EntityHandlerFactory.getHandlerFor(
                    BpssProcessSpecEntry.ENTITY_NAME, true);
      //handler.create(bpssProcSpecEntry);
      bpssProcSpecEntry = (BpssProcessSpecEntry)handler.createEntity(bpssProcSpecEntry); //NSL20051111

      if (this.getDocumentationCount() > 0)
        list.setParentEntryUId(specUId, bpssProcSpecEntry.getUId());
    }
    catch (Throwable th)
    {
      //TODO handle RemoteException, ParseException
      System.out.println("Unable to deploy " + bpssFork.getEntityName());
      th.printStackTrace();
      throw new GWFException();
    }
    return finalResult;
  }

  /**
   * DOCUMENT ME!
   * 
   * @param specUId DOCUMENT ME!
   * @param parentEntryUId DOCUMENT ME!
   * @throws GWFException DOCUMENT ME!
   */
  public void setParentEntryUId(long specUId, long parentEntryUId)
                         throws GWFException
  {
    try
    {
      Utilities.setParentEntryUId(specUId, parentEntryUId, this.getName(), 
                                  BpssFork.ENTITY_NAME);
    }
    catch (GWFException ex)
    {
      ex.printStackTrace();
      throw new GWFException();
    }
  }
  
  public Fork buildModel(GNElement elem)
  {
  	if (elem == null)
      return null;


      /** Unmarshals "name" attribute */
  	  super.setAttributeValue(name, elem.getAttribute("name"));

      /** Unmarshals "nameID" attribute */
  	  super.setAttributeValue(nameID, elem.getAttribute("nameID"));

    /** Unmarshals a list of "<<_tagName_>>" elements back to Documentation objects. */
    Iterator it1 = elem.getChildren(Documentation._tagName).iterator();
    while (it1.hasNext())
    {
    	Documentation doc = new Documentation();
      addDocumentation(doc.buildModel(
                                     (GNElement)it1.next()));
    }
    return this;
  }
  
  /**
   * Marshals this object to an element.
   */
  public GNElement buildElement()
  {
  	GNElement elem = GNXMLDocumentUtility.newElement(get_TagName());

    /** Marshals "name" attribute */
  	addAttributeToElement(elem, this._ATTR_DEFAULT_REQUIRED, name);

    /** Marshals "nameID" attribute */
  	addAttributeToElement(elem, this._ATTR_DEFAULT_IMPLIED, nameID);

    /** Marshals a list of Documentation objects to elements */
    Iterator it1 = _objDocumentation.iterator();
    while (it1.hasNext())
    {
      Documentation obj = (Documentation)it1.next();
      if (obj != null)
        elem.addElement(obj.buildElement());
    }
    return elem;
  }
}
