// %1023962281332:com.gridnode.pdip.app.deployment.bpss%
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

import com.gridnode.pdip.app.deploy.manager.IGWFDeployable;
import com.gridnode.pdip.framework.exceptions.domain.GWFException;
import com.gridnode.xml.adapters.GNAttribute;
import com.gridnode.xml.adapters.GNElement;
import com.gridnode.xml.adapters.GNXMLDocumentUtility;

/**
 * The Performs class represents the element "Performs" with the content
 * model defined as follows:
 * <p>
 * &lt;!ELEMENT Performs (Documentation)*&gt;<br>
 */
public class Performs
  extends AbstractBpssModel
  implements IGWFDeployable
{

  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4473886153909739580L;

	/** xml tag name of this element. */
  public static String _tagName = "Performs";

  
  /** Defines a inititiatingRoleIDRef attribute */
  public GNAttribute inititiatingRoleIDRef = GNXMLDocumentUtility.newAttribute("inititiatingRoleIDRef", "");
  
  /** Defines a initiatingRole attribute */
  public GNAttribute initiatingRole = GNXMLDocumentUtility.newAttribute("initiatingRole", "");
  
  /** Defines a respondingRoleIDRef attribute */
  public GNAttribute respondingRoleIDRef = GNXMLDocumentUtility.newAttribute("respondingRoleIDRef", "");
  
  /** Defines a respondingRole attribute */
  public GNAttribute respondingRole = GNXMLDocumentUtility.newAttribute("respondingRole", "");
  
  
  /** Defines a list of Documentation objects. */
  protected ArrayList _objDocumentation = new ArrayList();

  /**
     * Creates an empty Performs object
     */
  public Performs()
  {
    super();
  }

  /**
     * Gets the value of "inititiatingRoleIDRef" attribute.
     */
  public String getInititiatingRoleIDRef()
  {
    return inititiatingRoleIDRef.getValue();
  }

  /**
     * Replaces the existing attribute value with a new value.
     * @param value    New value.
     */
  public void setInititiatingRoleIDRef(String value_)
  {
    inititiatingRoleIDRef.setValue(value_);
  }

  /**
     * Gets the value of "initiatingRole" attribute.
     */
  public String getInitiatingRole()
  {
    return initiatingRole.getValue();
  }

  /**
     * Replaces the existing attribute value with a new value.
     * @param value    New value.
     */
  public void setInitiatingRole(String value_)
  {
    initiatingRole.setValue(value_);
  }

  /**
     * Gets the value of "respondingRoleIDRef" attribute.
     */
  public String getRespondingRoleIDRef()
  {
    return respondingRoleIDRef.getValue();
  }

  /**
     * Replaces the existing attribute value with a new value.
     * @param value    New value.
     */
  public void setRespondingRoleIDRef(String value_)
  {
    respondingRoleIDRef.setValue(value_);
  }

  /**
     * Gets the value of "respondingRole" attribute.
     */
  public String getRespondingRole()
  {
    return respondingRole.getValue();
  }

  /**
     * Replaces the existing attribute value with a new value.
     * @param value    New value.
     */
  public void setRespondingRole(String value_)
  {
    respondingRole.setValue(value_);
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
    return 1;
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
  }
  
  /**
   * Unmarshals the specified "Performs" element back to a Performs object.
   */
  public Performs buildModel(GNElement elem)
  {
  	if (elem == null)
      return null;

      /** Unmarshals "inititiatingRoleIDRef" attribute */
  		super.setAttributeValue(inititiatingRoleIDRef, elem.getAttribute(
                                                       "inititiatingRoleIDRef"));
      
      /** Unmarshals "initiatingRole" attribute */
  		super.setAttributeValue(initiatingRole, elem.getAttribute("initiatingRole"));

      /** Unmarshals "respondingRoleIDRef" attribute */
  		super.setAttributeValue(respondingRoleIDRef, elem.getAttribute("respondingRoleIDRef"));
      
      /** Unmarshals "respondingRole" attribute */
  		super.setAttributeValue(respondingRole, elem.getAttribute("respondingRole"));

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

    /** Marshals "inititiatingRoleIDRef" attribute */
  	addAttributeToElement(elem, this._ATTR_DEFAULT_IMPLIED, inititiatingRoleIDRef);

    /** Marshals "initiatingRole" attribute */
  	addAttributeToElement(elem, this._ATTR_DEFAULT_IMPLIED, initiatingRole);

    /** Marshals "respondingRoleIDRef" attribute */
  	addAttributeToElement(elem, this._ATTR_DEFAULT_IMPLIED, respondingRoleIDRef);

    /** Marshals "respondingRole" attribute */
  	addAttributeToElement(elem, this._ATTR_DEFAULT_IMPLIED, respondingRole);

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