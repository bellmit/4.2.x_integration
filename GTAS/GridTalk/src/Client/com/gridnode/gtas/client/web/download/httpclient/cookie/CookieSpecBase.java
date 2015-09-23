/*
 * $Header: /home/cvs/jakarta-commons/httpclient/src/java/org/apache/commons/httpclient/cookie/CookieSpecBase.java,v 1.16 2003/06/12 19:12:16 olegk Exp $
 * $Revision: 1.16 $
 * $Date: 2003/06/12 19:12:16 $
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

package com.gridnode.gtas.client.web.download.httpclient.cookie;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.gridnode.gtas.client.web.download.httpclient.Cookie;
import com.gridnode.gtas.client.web.download.httpclient.Header;
import com.gridnode.gtas.client.web.download.httpclient.HeaderElement;
import com.gridnode.gtas.client.web.download.httpclient.HttpException;
import com.gridnode.gtas.client.web.download.httpclient.NameValuePair;
import com.gridnode.gtas.client.web.download.httpclient.util.DateParseException;
import com.gridnode.gtas.client.web.download.httpclient.util.DateParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * Cookie management functions shared by all specification.
 *
 * @author  B.C. Holmes
 * @author <a href="mailto:jericho@thinkfree.com">Park, Sung-Gu</a>
 * @author <a href="mailto:dsale@us.britannica.com">Doug Sale</a>
 * @author Rod Waldhoff
 * @author dIon Gillard
 * @author Sean C. Sullivan
 * @author <a href="mailto:JEvans@Cyveillance.com">John Evans</a>
 * @author Marc A. Saegesser
 * @author <a href="mailto:oleg@ural.ru">Oleg Kalnichevski</a>
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 * 
 * @since 2.0 
 */
public class CookieSpecBase implements CookieSpec {
    
    /** Log object */
    protected static final Log LOG = LogFactory.getLog(CookieSpec.class);

    /** Default constructor */
    public CookieSpecBase() {
        super();
    }


    /**
      * Parses the Set-Cookie value into an array of <tt>Cookie</tt>s.
      *
      * <P>The syntax for the Set-Cookie response header is:
      *
      * <PRE>
      * set-cookie      =    "Set-Cookie:" cookies
      * cookies         =    1#cookie
      * cookie          =    NAME "=" VALUE * (";" cookie-av)
      * NAME            =    attr
      * VALUE           =    value
      * cookie-av       =    "Comment" "=" value
      *                 |    "Domain" "=" value
      *                 |    "Max-Age" "=" value
      *                 |    "Path" "=" value
      *                 |    "Secure"
      *                 |    "Version" "=" 1*DIGIT
      * </PRE>
      *
      * @param host the host from which the <tt>Set-Cookie</tt> value was
      * received
      * @param port the port from which the <tt>Set-Cookie</tt> value was
      * received
      * @param path the path from which the <tt>Set-Cookie</tt> value was
      * received
      * @param secure <tt>true</tt> when the <tt>Set-Cookie</tt> value was
      * received over secure conection
      * @param header the <tt>Set-Cookie</tt> received from the server
      * @return an array of <tt>Cookie</tt>s parsed from the Set-Cookie value
      * @throws MalformedCookieException if an exception occurs during parsing
      */
    public Cookie[] parse(String host, int port, String path, 
        boolean secure, final String header) 
        throws MalformedCookieException {
            
        LOG.trace("enter CookieSpecBase.parse(" 
            + "String, port, path, boolean, Header)");

        if (host == null) {
            throw new IllegalArgumentException(
                "Host of origin may not be null");
        }
        if (host.trim().equals("")) {
            throw new IllegalArgumentException(
                "Host of origin may not be blank");
        }
        if (port < 0) {
            throw new IllegalArgumentException("Invalid port: " + port);
        }
        if (path == null) {
            throw new IllegalArgumentException(
                "Path of origin may not be null.");
        }
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null.");
        }

        if (path.trim().equals("")) {
            path = PATH_DELIM;
        }
        host = host.toLowerCase();
    
        HeaderElement[] headerElements = null;
        try {
            headerElements = HeaderElement.parse(header);
        } catch (HttpException e) {
            throw new MalformedCookieException(e.getMessage());
        } 
    
        String defaultPath = path;    
        int lastSlashIndex = defaultPath.lastIndexOf(PATH_DELIM);
        if (lastSlashIndex >= 0) {
            if (lastSlashIndex == 0) {
                //Do not remove the very first slash
                lastSlashIndex = 1;
            }
            defaultPath = defaultPath.substring(0, lastSlashIndex);
        }
        
        Cookie[] cookies = new Cookie[headerElements.length];

        for (int i = 0; i < headerElements.length; i++) {

            HeaderElement headerelement = headerElements[i];
            Cookie cookie = new Cookie(host,
                                       headerelement.getName(),
                                       headerelement.getValue(),
                                       defaultPath, 
                                       null,
                                       false);

            // cycle through the parameters
            NameValuePair[] parameters = headerelement.getParameters();
            // could be null. In case only a header element and no parameters.
            if (parameters != null) {

                for (int j = 0; j < parameters.length; j++) {
                    parseAttribute(parameters[j], cookie);
                }
            }
            cookies[i] = cookie;
        }
        return cookies;
    }


    /**
      * Parse the <tt>"Set-Cookie"</tt> {@link Header} into an array of {@link
      * Cookie}s.
      *
      * <P>The syntax for the Set-Cookie response header is:
      *
      * <PRE>
      * set-cookie      =    "Set-Cookie:" cookies
      * cookies         =    1#cookie
      * cookie          =    NAME "=" VALUE * (";" cookie-av)
      * NAME            =    attr
      * VALUE           =    value
      * cookie-av       =    "Comment" "=" value
      *                 |    "Domain" "=" value
      *                 |    "Max-Age" "=" value
      *                 |    "Path" "=" value
      *                 |    "Secure"
      *                 |    "Version" "=" 1*DIGIT
      * </PRE>
      *
      * @param host the host from which the <tt>Set-Cookie</tt> header was
      * received
      * @param port the port from which the <tt>Set-Cookie</tt> header was
      * received
      * @param path the path from which the <tt>Set-Cookie</tt> header was
      * received
      * @param secure <tt>true</tt> when the <tt>Set-Cookie</tt> header was
      * received over secure conection
      * @param header the <tt>Set-Cookie</tt> received from the server
      * @return an array of <tt>Cookie</tt>s parsed from the <tt>"Set-Cookie"
      * </tt> header
      * @throws MalformedCookieException if an exception occurs during parsing
      */
    public Cookie[] parse(
        String host, int port, String path, boolean secure, final Header header)
        throws MalformedCookieException {
            
        LOG.trace("enter CookieSpecBase.parse("
            + "String, port, path, boolean, String)");
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null.");
        }
        return parse(host, port, path, secure, header.getValue());
    }


    /**
      * Parse the cookie attribute and update the corresponsing {@link Cookie}
      * properties.
      *
      * @param attribute {@link HeaderElement} cookie attribute from the
      * <tt>Set- Cookie</tt>
      * @param cookie {@link Cookie} to be updated
      * @throws MalformedCookieException if an exception occurs during parsing
      */

    public void parseAttribute(
        final NameValuePair attribute, final Cookie cookie)
        throws MalformedCookieException {
            
        if (attribute == null) {
            throw new IllegalArgumentException("Attribute may not be null.");
        }
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
        final String paramName = attribute.getName().toLowerCase();
        String paramValue = attribute.getValue();

        if (paramName.equals("path")) {

            if ((paramValue == null) || (paramValue.trim().equals(""))) {
                paramValue = "/";
            }
            cookie.setPath(paramValue);
            cookie.setPathAttributeSpecified(true);

        } else if (paramName.equals("domain")) {

            if (paramValue == null) {
                throw new MalformedCookieException(
                    "Missing value for domain attribute");
            }
            if (paramValue.trim().equals("")) {
                throw new MalformedCookieException(
                    "Blank value for domain attribute");
            }
            cookie.setDomain(paramValue);
            cookie.setDomainAttributeSpecified(true);

        } else if (paramName.equals("max-age")) {

            if (paramValue == null) {
                throw new MalformedCookieException(
                    "Missing value for max-age attribute");
            }
            int age;
            try {
                age = Integer.parseInt(paramValue);
            } catch (NumberFormatException e) {
                throw new MalformedCookieException ("Invalid max-age "
                    + "attribute: " + e.getMessage());
            }
            cookie.setExpiryDate(
                new Date(System.currentTimeMillis() + age * 1000L));

        } else if (paramName.equals("secure")) {

            cookie.setSecure(true);

        } else if (paramName.equals("comment")) {

            cookie.setComment(paramValue);

        } else if (paramName.equals("expires")) {

            if (paramValue == null) {
                throw new MalformedCookieException(
                    "Missing value for expires attribute");
            }
            // trim single quotes around expiry if present
            // see http://nagoya.apache.org/bugzilla/show_bug.cgi?id=5279
            if (paramValue.length() > 1 
                && paramValue.startsWith("'") 
                && paramValue.endsWith("'")) {
                paramValue 
                    = paramValue.substring (1, paramValue.length() - 1);
            }

            try {
                cookie.setExpiryDate(DateParser.parseDate(paramValue));
            } catch (DateParseException dpe) {
                LOG.debug("Error parsing cookie date", dpe);
                throw new MalformedCookieException(
                    "Unable to parse expiration date parameter: " 
                    + paramValue);
            }
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Unrecognized cookie attribute: " 
                    + attribute.toString());
            }
        }
    }

    
    /**
      * Performs most common {@link Cookie} validation
      *
      * @param host the host from which the {@link Cookie} was received
      * @param port the port from which the {@link Cookie} was received
      * @param path the path from which the {@link Cookie} was received
      * @param secure <tt>true</tt> when the {@link Cookie} was received using a
      * secure connection
      * @param cookie The cookie to validate.
      * @throws MalformedCookieException if an exception occurs during
      * validation
      */
    
    public void validate(String host, int port, String path, 
        boolean secure, final Cookie cookie) 
        throws MalformedCookieException {
            
        LOG.trace("enter CookieSpecBase.validate("
            + "String, port, path, boolean, Cookie)");
        if (host == null) {
            throw new IllegalArgumentException(
                "Host of origin may not be null");
        }
        if (host.trim().equals("")) {
            throw new IllegalArgumentException(
                "Host of origin may not be blank");
        }
        if (port < 0) {
            throw new IllegalArgumentException("Invalid port: " + port);
        }
        if (path == null) {
            throw new IllegalArgumentException(
                "Path of origin may not be null.");
        }
        if (path.trim().equals("")) {
            path = PATH_DELIM;
        }
        host = host.toLowerCase();
        // check version
        if (cookie.getVersion() < 0) {
            throw new MalformedCookieException ("Illegal version number " 
                + cookie.getValue());
        }

        // security check... we musn't allow the server to give us an
        // invalid domain scope

        // Validate the cookies domain attribute.  NOTE:  Domains without 
        // any dots are allowed to support hosts on private LANs that don't 
        // have DNS names.  Since they have no dots, to domain-match the 
        // request-host and domain must be identical for the cookie to sent 
        // back to the origin-server.
        if (host.indexOf(".") >= 0) {
            // Not required to have at least two dots.  RFC 2965.
            // A Set-Cookie2 with Domain=ajax.com will be accepted.

            // domain must match host
            if (!host.endsWith(cookie.getDomain())) {
                throw new MalformedCookieException(
                    "Illegal domain attribute \"" + cookie.getDomain() 
                    + "\". Domain of origin: \"" + host + "\"");
            }
        } else {
            if (!host.equals(cookie.getDomain())) {
                throw new MalformedCookieException(
                    "Illegal domain attribute \"" + cookie.getDomain() 
                    + "\". Domain of origin: \"" + host + "\"");
            }
        }

        // another security check... we musn't allow the server to give us a
        // cookie that doesn't match this path

        if (!path.startsWith(cookie.getPath())) {
            throw new MalformedCookieException(
                "Illegal path attribute \"" + cookie.getPath() 
                + "\". Path of origin: \"" + path + "\"");
        }
    }


    /**
     * Return <tt>true</tt> if the cookie should be submitted with a request
     * with given attributes, <tt>false</tt> otherwise.
     * @param host the host to which the request is being submitted
     * @param port the port to which the request is being submitted (ignored)
     * @param path the path to which the request is being submitted
     * @param secure <tt>true</tt> if the request is using a secure connection
     * @param cookie {@link Cookie} to be matched
     * @return true if the cookie matches the criterium
     */

    public boolean match(String host, int port, String path, 
        boolean secure, final Cookie cookie) {
            
        LOG.trace("enter CookieSpecBase.match("
            + "String, int, String, boolean, Cookie");
            
        if (host == null) {
            throw new IllegalArgumentException(
                "Host of origin may not be null");
        }
        if (host.trim().equals("")) {
            throw new IllegalArgumentException(
                "Host of origin may not be blank");
        }
        if (port < 0) {
            throw new IllegalArgumentException("Invalid port: " + port);
        }
        if (path == null) {
            throw new IllegalArgumentException(
                "Path of origin may not be null.");
        }
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (path.trim().equals("")) {
            path = PATH_DELIM;
        }
        host = host.toLowerCase();
        if (cookie.getDomain() == null) {
            LOG.warn("Invalid cookie state: domain not specified");
            return false;
        }
        if (cookie.getPath() == null) {
            LOG.warn("Invalid cookie state: path not specified");
            return false;
        }
        
        return
            // only add the cookie if it hasn't yet expired 
            (cookie.getExpiryDate() == null 
                || cookie.getExpiryDate().after(new Date()))
            // and the domain pattern matches 
            && (domainMatch(host, cookie.getDomain()))
            // and the path is null or matching
            && (pathMatch(path, cookie.getPath()))
            // and if the secure flag is set, only if the request is 
            // actually secure 
            && (cookie.getSecure() ? secure : true);      
    }

    /**
     * Performs a domain-match as described in RFC2109.
     * @param host The host to check.
     * @param domain The domain.
     * @return true if the specified host matches the given domain.
     */
    private static boolean domainMatch(String host, String domain) {
        boolean match = host.equals(domain) 
            || (domain.startsWith(".") && host.endsWith(domain));

        return match;
    }

    /**
     * Performs a path-match slightly smarter than a straight-forward startsWith
     * check.
     * @param path The path to check.
     * @param topmostPath The path to check against.
     * @return true if the paths match
     */
    private static boolean pathMatch(
        final String path, final String topmostPath) {
            
        boolean match = path.startsWith (topmostPath);
        
        // if there is a match and these values are not exactly the same we have
        // to make sure we're not matcing "/foobar" and "/foo"
        if (match && path.length() != topmostPath.length()) {
            if (!topmostPath.endsWith(PATH_DELIM)) {
                match = (path.charAt(topmostPath.length()) == PATH_DELIM_CHAR);
            }
        }
        return match;
    }

    /**
     * Return an array of {@link Cookie}s that should be submitted with a
     * request with given attributes, <tt>false</tt> otherwise.
     * @param host the host to which the request is being submitted
     * @param port the port to which the request is being submitted (currently
     * ignored)
     * @param path the path to which the request is being submitted
     * @param secure <tt>true</tt> if the request is using a secure protocol
     * @param cookies an array of <tt>Cookie</tt>s to be matched
     * @return an array of <tt>Cookie</tt>s matching the criterium
     */

    public Cookie[] match(String host, int port, String path, 
        boolean secure, final Cookie cookies[]) {
            
        LOG.trace("enter CookieSpecBase.match("
            + "String, int, String, boolean, Cookie[])");

        if (host == null) {
            throw new IllegalArgumentException(
                "Host of origin may not be null");
        }
        if (host.trim().equals("")) {
            throw new IllegalArgumentException(
                "Host of origin may not be blank");
        }
        if (port < 0) {
            throw new IllegalArgumentException("Invalid port: " + port);
        }
        if (path == null) {
            throw new IllegalArgumentException(
                "Path of origin may not be null.");
        }
        if (cookies == null) {
            throw new IllegalArgumentException("Cookie array may not be null");
        }
        if (path.trim().equals("")) {
            path = PATH_DELIM;
        }
        host = host.toLowerCase();

        if (cookies.length <= 0) {
            return null;
        }
        List matching = new LinkedList();
        for (int i = 0; i < cookies.length; i++) {
            if (match(host, port, path, secure, cookies[i])) {
                addInPathOrder(matching, cookies[i]);
            }
        }
        return (Cookie[]) matching.toArray(new Cookie[matching.size()]);
    }


    /**
     * Adds the given cookie into the given list in descending path order. That
     * is, more specific path to least specific paths.  This may not be the
     * fastest algorythm, but it'll work OK for the small number of cookies
     * we're generally dealing with.
     *
     * @param list - the list to add the cookie to
     * @param addCookie - the Cookie to add to list
     */
    private static void addInPathOrder(List list, Cookie addCookie) {
        int i = 0;

        for (i = 0; i < list.size(); i++) {
            Cookie c = (Cookie) list.get(i);
            if (addCookie.compare(addCookie, c) > 0) {
                break;
            }
        }
        list.add(i, addCookie);
    }

    /**
     * Return a string suitable for sending in a <tt>"Cookie"</tt> header
     * @param cookie a {@link Cookie} to be formatted as string
     * @return a string suitable for sending in a <tt>"Cookie"</tt> header.
     */
    public String formatCookie(Cookie cookie) {
        LOG.trace("enter CookieSpecBase.formatCookie(Cookie)");
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        StringBuffer buf = new StringBuffer();
        buf.append(cookie.getName());
        buf.append("=");
        String s = cookie.getValue();
        if (s != null) {
            buf.append(s);
        }
        return buf.toString();
    }

    /**
     * Create a <tt>"Cookie"</tt> header value containing all {@link Cookie}s in
     * <i>cookies</i> suitable for sending in a <tt>"Cookie"</tt> header
     * @param cookies an array of {@link Cookie}s to be formatted
     * @return a string suitable for sending in a Cookie header.
     * @throws IllegalArgumentException if an input parameter is illegal
     */

    public String formatCookies(Cookie[] cookies)
      throws IllegalArgumentException {
        LOG.trace("enter CookieSpecBase.formatCookies(Cookie[])");
        if (cookies == null) {
            throw new IllegalArgumentException("Cookie array may not be null");
        }
        if (cookies.length == 0) {
            throw new IllegalArgumentException("Cookie array may not be empty");
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < cookies.length; i++) {
            if (i > 0) {
                buffer.append("; ");
            }
            buffer.append(formatCookie(cookies[i]));
        }
        return buffer.toString();
    }


    /**
     * Create a <tt>"Cookie"</tt> {@link Header} containing all {@link Cookie}s
     * in <i>cookies</i>.
     * @param cookies an array of {@link Cookie}s to be formatted as a <tt>"
     * Cookie"</tt> header
     * @return a <tt>"Cookie"</tt> {@link Header}.
     */
    public Header formatCookieHeader(Cookie[] cookies) {
        LOG.trace("enter CookieSpecBase.formatCookieHeader(Cookie[])");
        return new Header("Cookie", formatCookies(cookies));
    }


    /**
     * Create a <tt>"Cookie"</tt> {@link Header} containing the {@link Cookie}.
     * @param cookie <tt>Cookie</tt>s to be formatted as a <tt>Cookie</tt>
     * header
     * @return a Cookie header.
     */
    public Header formatCookieHeader(Cookie cookie) {
        LOG.trace("enter CookieSpecBase.formatCookieHeader(Cookie)");
        return new Header("Cookie", formatCookie(cookie));
    }

}
