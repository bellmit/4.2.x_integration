/*
 * $Header: /home/cvs/jakarta-commons/httpclient/src/java/org/apache/commons/httpclient/NTCredentials.java,v 1.6 2003/01/30 05:01:54 jsdever Exp $
 * $Revision: 1.6 $
 * $Date: 2003/01/30 05:01:54 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */

package com.gridnode.gtas.client.web.download.httpclient;

/**
 * <p>Username and password {@link Credentials}.</p>
 *
 * @author <a href="mailto:adrian@ephox.com">Adrian Sutton</a>
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 * 
 * @version $Revision: 1.6 $ $Date: 2003/01/30 05:01:54 $
 * 
 * @since 2.0
 */
public class NTCredentials extends UsernamePasswordCredentials {

    // ----------------------------------------------------- Instance Variables

    /** The Domain.  */
    private String domain;

    /** The Host.  */
    private String host;


    // ----------------------------------------------------------- Constructors

    /**
     * Default constructor.
     */
    public NTCredentials() {
        super();
    }

    /**
     * Constructor.
     * @param userName The user name.
     * @param password The password.
     * @param host The host.
     * @param domain The domain.
     */
    public NTCredentials(String userName, String password, String host,
            String domain) {
        super(userName, password);
        this.domain = domain;
        this.host = host;
    }
    // ------------------------------------------------------- Instance Methods


    /**
     * Domain property setter.
     *
     * @param domain the NT domain to authenticate in.
     * 
     * @see #getDomain()
     * 
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * Domain property getter.
     *
     * @return String domain
     * 
     * @see #setDomain(String)
     * 
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Host property setter.
     *
     * @param host the Host the user is logged into.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Host property getter.
     *
     * @return String host.
     */
    public String getHost() {
        return this.host;
    }
    
    /**
     * Return a string representation of this object.
     * @return A string represenation of this object.
     */
    public String toString() {
        final StringBuffer sbResult = new StringBuffer(super.toString());
        
        sbResult.append(":");
        sbResult.append(this.host == null ? "null" : this.host);
        sbResult.append(this.domain == null ? "null" : this.domain);

        return sbResult.toString();
    }

}
