/*
 * $Header: /home/cvs/jakarta-commons/httpclient/src/java/org/apache/commons/httpclient/HttpClient.java,v 1.76 2003/05/12 02:42:42 mbecke Exp $
 * $Revision: 1.76 $
 * $Date: 2003/05/12 02:42:42 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999-2003 The Apache Software Foundation.  All rights
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

import java.io.IOException;
import java.net.URL;
import java.security.Security; 
import java.security.Provider;  

import com.gridnode.gtas.client.web.download.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <p>
 * An HTTP "user-agent", containing an {@link HttpState} and
 * one or more {@link HttpConnection}s, to which
 * {@link HttpMethod}s can be applied.
 * </p>
 * @author <a href="mailto:remm@apache.org">Remy Maucherat</a>
 * @author <a href="mailto:rwaldhoff@apache.org">Rodney Waldhoff</a>
 * @author Sean C. Sullivan
 * @author <a href="mailto:dion@apache.org">dIon Gillard</a>
 * @author Ortwin Gl�ck
 * @author <a href="mailto:becke@u.washington.edu">Michael Becke</a>
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 * @author Sam Maloney
 * @author Laura Werner
 * 
 * @version $Revision: 1.76 $ $Date: 2003/05/12 02:42:42 $
 */
public class HttpClient {


    // -------------------------------------------------------------- Constants

    /** Log object for this class. */
    private static final Log LOG = LogFactory.getLog(HttpClient.class);

    static {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Java version: " + System.getProperty("java.version"));
            LOG.debug("Java vendor: " + System.getProperty("java.vendor"));
            LOG.debug("Java class path: " + System.getProperty("java.class.path"));
            LOG.debug("Operating system name: " + System.getProperty("os.name"));
            LOG.debug("Operating system architecture: " + System.getProperty("os.arch"));
            LOG.debug("Operating system version: " + System.getProperty("os.version"));

            Provider[] providers = Security.getProviders();
            for (int i = 0; i < providers.length; i++) {
                Provider provider = providers[i];
                LOG.debug(provider.getName() + " " + provider.getVersion()
                   + ": " + provider.getInfo());   
            }

        }
    }
    // ----------------------------------------------------------- Constructors

    /**
     * Creates an HttpClient using <code>SimpleHttpConnectionManager</code>.
     * 
     * @see SimpleHttpConnectionManager
     */
    public HttpClient() {
        this(new SimpleHttpConnectionManager());
    }

    /**
     * Creates an HttpClient with a user specified connection manager.
     * @param httpConnectionManager The connection manager to use.
     * 
     * @since 2.0
     */
    public HttpClient(HttpConnectionManager httpConnectionManager) {

        if (httpConnectionManager == null) {
            throw new IllegalArgumentException("httpConnectionManager cannot be null");  
        }

        this.state = new HttpState();
        this.httpConnectionManager = httpConnectionManager;

        this.hostConfiguration = new HostConfiguration();
        
    }
    
    // ----------------------------------------------------- Instance Variables

    /** The current connection manager */
    private HttpConnectionManager httpConnectionManager;

    /**
     * My {@link HttpState state}.
     */
    private HttpState state;

    /** the timout when waiting for a connection from the connectionManager */
    private long httpConnectionTimeout = 0;

    /** The timeout in milliseconds*/
    private int timeoutInMilliseconds = 0;

    /** The connection timeout. */
    private int connectionTimeout = 0;

    /** The host configuration to use */
    private HostConfiguration hostConfiguration;
    
    /** True if strict mode is enabled. */
    private boolean strictMode = false;

    // ------------------------------------------------------------- Properties

    /**
     * Get my {@link HttpState state}.
     *
     * @see #setState(HttpState)
     * @return the shared client state
     */
    public synchronized HttpState getState() {
        return state;
    }

    /**
     * Set my {@link HttpState state}.
     *
     * @see #getState()
     * @param state the new state for the client
     */
    public synchronized void setState(HttpState state) {
        this.state = state;
    }

    /**
     *
     * @param strictMode <code>true</code> if strict mode should be used
     *
     * @see #isStrictMode()
     *
     */
    public synchronized void setStrictMode(boolean strictMode) {
        this.strictMode = strictMode;
    }

    /**
     *
     * @return <code>true</code> if strict mode being used
     *
     * @see #setStrictMode(boolean)
     *
     */
    public synchronized boolean isStrictMode() {
        return strictMode;
    }

    /**
     * Sets the SO_TIMEOUT which is the timeout for waiting for data.
     *
     * A timeout value of zero is interpreted as an infinite timeout.
     *
     * @param newTimeoutInMilliseconds Timeout in milliseconds
     *
     */
    public synchronized void setTimeout(int newTimeoutInMilliseconds) {
        this.timeoutInMilliseconds = newTimeoutInMilliseconds;
    }

    /**
     * Sets the timeout used when retrieving an HttpConnection from the
     * HttpConnectionManager.
     * 
     * @param timeout the timeout in milliseconds
     * 
     * @see HttpConnectionManager#getConnection(HostConfiguration, long)
     */
    public synchronized void setHttpConnectionFactoryTimeout(long timeout) {
        this.httpConnectionTimeout = timeout;
    }

    /**
     * Sets the timeout until a connection is etablished. A value of 0 means
     * the timeout is not used. The default value is 0.
     * @see HttpConnection#setConnectionTimeout(int)
     * @param newTimeoutInMilliseconds Timeout in milliseconds.
     */
    public synchronized void setConnectionTimeout(int newTimeoutInMilliseconds) {
       this.connectionTimeout = newTimeoutInMilliseconds;
    }

    // --------------------------------------------------------- Public Methods

    /**
     * @deprecated use hostConfiguration
     * 
     * Sets the host, port and protocol(http) to be used when executing a
     * method.
     * 
     * @param host the host to connect to
     * @param port the port to connect to
     *
     * @see #getHostConfiguration()
     */
    public void startSession(String host, int port) {
        LOG.trace("enter HttpClient.startSession(String, int)");
        startSession(host, port, false);
    }

    /**
     * @deprecated use hostConfiguration
     * 
     * Sets the host, port and protocol to be used when executing a method.
     * 
     * @param host the host to connect to
     * @param port the port to connect to
     * @param https when <code>true</code>, create an HTTPS session
     *
     * @see #getHostConfiguration()
     */    
    public void startSession(String host, int port, boolean https) {
        LOG.trace("enter HttpClient.startSession(String, int, boolean)");

        if (LOG.isDebugEnabled()) {
            LOG.debug("HttpClient.startSession(String,int,boolean): Host:"
                + host + " Port:" + port + " HTTPS:" + https);
        }
        
        this.hostConfiguration.setHost(host, port, https ? "https" : "http");
    }

    /**
     * @deprecated use hostConfiguration and httpState
     * 
     * Sets the host, port, protocol(http) and credentials to be used when
     * executing a method.
     *
     * @param host the host to connect to
     * @param port the port to connect to
     * @param creds the default credentials to use
     *
     * @see #getHostConfiguration()
     * @see #getState()
     * @see #startSession(String, int, Credentials, boolean)
     */
    public void startSession(String host, int port, Credentials creds) {
        LOG.trace("enter HttpClient.startSession(String, int, Credentials)");
        startSession(host, port, creds, false);
    }

    /**
     * @deprecated use hostConfiguration and httpState
     *
     * Sets the host, port, protocol and credentials to be used when executing a
     * method.
     *
     * @param host the host to connect to
     * @param port the port to connect to
     * @param creds the default credentials to use
     * @param https when <code>true</code>, create an HTTPS session
     *
     * @see #getHostConfiguration()
     * @see #getState()
     */
    public void startSession(String host, int port, Credentials creds, boolean https) {
        LOG.trace("enter HttpClient.startSession(String, int, Credentials, boolean)");

        if (LOG.isDebugEnabled()) {
            LOG.debug(
                "Starting HttpClient session"
                + " Host:" + host
                + " Port:" + port + " Credentials:" + creds
                + " HTTPS:" + https);
        }
        getState().setCredentials(null, creds);
        this.hostConfiguration.setHost(
            host,
            port,
            https ? "https" : "http"
        );
    }

    /**
     * @deprecated use hostConfiguration and httpState
     *
     * Sets the host, port, protocol and credentials to be used when executing a
     * method using the server specified by the scheme, userinfo, host and port
     * of the given <i>uri</i>.
     * <p>
     * Note that the path component is not utilized.
     * <p>
     * @param uri an <code>HttpURL</code> or <code>HttpsURL</code> instance; the
     * {@link URI URI} from which the scheme, userinfo, host and port of the
     * session are determined
     *
     * @throws IllegalStateException not enough information to process
     * @throws URIException If the URI is bad.
     * 
     * @see #getHostConfiguration()
     * @see #getState()
     */
    public void startSession(URI uri) 
        throws URIException, IllegalStateException {
            
        LOG.trace("enter HttpClient.startSession(URI)");

        String scheme = uri.getScheme();
        if (scheme == null) {   // it may a URI instance or abs_path
            LOG.error("no scheme to start a session");
            throw new IllegalStateException("no scheme to start a session");
        }

        Protocol protocol = Protocol.getProtocol(scheme);

        String userinfo = uri.getUserinfo();
        if (userinfo != null) {
            getState().setCredentials(null,
                    new UsernamePasswordCredentials(userinfo));
        }
        String host = uri.getHost();
        if (host == null || host.length() == 0) {
            LOG.error("no host to start a session");
            throw new IllegalStateException("no host to start a session");
        }
        int port = uri.getPort();
        if (port == -1) {   // neither HttpURL or HttpsURL instance
            LOG.error("HttpURL or HttpsURL instance required");
            throw new IllegalStateException
                ("HttpURL or HttpsURL instance required");
        }
        this.hostConfiguration.setHost(host, null, port, protocol);
    }

    /**
     * @deprecated use hostConfiguration
     *
     * Sets the host, port and protocol to be used when executing a method.
     * <p>
     * Note that everything but the protocol, host and port of the
     * given <i>url</i> is ignored.
     * </p>
     * @param url the {@link URL URL} from which the protocol, host, and port of
     * the session are determined
     * 
     * @exception IllegalArgumentException if the protocol is not http or https
     *
     * @see #getHostConfiguration()
     */
    public void startSession(URL url) throws IllegalArgumentException {
        LOG.trace("enter HttpClient.startSession(String, int, Credentials, boolean)");

        int port = url.getPort();
        Protocol protocol = Protocol.getProtocol(url.getProtocol());

        hostConfiguration.setHost(url.getHost(), null, port, protocol);
    }

    /**
     * @deprecated use hostConfiguration and httpState
     *
     * Sets the host, port, protocol and credentials to be used when executing a
     * method.
     * <p>
     * Note that everything but the protocol, host and port of the
     * given <i>url</i> is ignored.
     * </p>
     * @param url the {@link URL URL} from which the protocol, host, and port of
     * the session are determined
     * @param creds the default credentials to use
     *  
     * @exception IllegalArgumentException if the protocol is not http or https
     *
     * @see #getHostConfiguration()   
     * @see #getState()
     */
    public void startSession(URL url, Credentials creds) 
        throws IllegalArgumentException {
            
        LOG.trace("enter HttpClient.startSession(URL, Credentials)");
        getState().setCredentials(null, creds);
        startSession(url);
    }

    /**
     * @deprecated use hostConfiguration
     * 
     * Sets the host, port, protocol(http) and proxy to be used when executing a
     * method.
     * 
     * @param host the host to connect to
     * @param port the port to connect to
     * @param proxyhost the proxy host to connect via
     * @param proxyport the proxy port to connect via
     *
     * @see #getHostConfiguration()
     */
    public void startSession(String host, int port, String proxyhost, int proxyport) {
        LOG.trace("enter HttpClient.startSession(String, int, String, int)");
        startSession(host, port, proxyhost, proxyport, false);
    }

    /**
     * @deprecated use hostConfiguration
     * 
     * Sets the host, port, protocol and proxy to be used when executing a
     * method.
     * 
     * @param host the host to connect to
     * @param port the port to connect to
     * @param proxyhost the proxy host to connect via
     * @param proxyport the proxy port to connect via
     * @param secure whether or not to connect using HTTPS
     * 
     * @see #getHostConfiguration()
     */
    public void startSession(String host, int port, 
        String proxyhost, int proxyport, boolean secure) {
            
        LOG.trace("enter HttpClient.startSession("
            + "String, int, String, int, boolean)");
        this.hostConfiguration.setHost (host, port, secure ? "https" : "http");
        this.hostConfiguration.setProxy(proxyhost, proxyport);
    }

    /**
     * Executes the given method.
     *
     * @param method the {@link HttpMethod} to execute.
     * @return the method's response code
     *
     * @throws IOException if an I/O error occurs
     * @throws HttpException if a protocol exception occurs
     */
    public int executeMethod(HttpMethod method)
        throws IOException, HttpException  {
            
        LOG.trace("enter HttpClient.executeMethod(HttpMethod)");
        // execute this method and use its host configuration, if it has one
        return executeMethod(
            method.getHostConfiguration() != null 
            ? method.getHostConfiguration()
            : getHostConfiguration(), 
            method,
            null
        );
        
    }

    /**
    * Executes the given method.
    *
    * @param hostConfiguration The configuration to use.
    * @param method the {@link HttpMethod} to execute.
    * @return the method's response code
    *
    * @throws IOException if an I/O error occurs
    * @throws HttpException if a protocol exception occurs
    * @since 2.0
    */
    public int executeMethod(HostConfiguration hostConfiguration, HttpMethod method)
        throws IOException, HttpException {
    
        LOG.trace("enter HttpClient.executeMethod(HostConfiguration,HttpMethod)");
    
        return executeMethod(hostConfiguration, method, null); 
    }
    

    
    /**
     * Executes the given method.
     *
     * @param hostConfiguration The configuration to use.
     * @param method the {@link HttpMethod} to execute.
     * @param state the {@link HttpState} to use when executing the method.
     * If <code>null</code>, the state returned by {@link #getState} will be used instead.
     *
     * @return the method's response code
     *
     * @throws IOException if an I/O error occurs
     * @throws HttpException if a protocol exception occurs
     * @since 2.0
     */
    public int executeMethod(HostConfiguration hostConfiguration, 
        HttpMethod method, HttpState state)
        throws IOException, HttpException  {
            
        LOG.trace("enter HttpClient.executeMethod(HostConfiguration,HttpMethod,HttpState)");

        if (method == null) {
            throw new IllegalArgumentException("HttpMethod parameter may not be null");
        }

        int soTimeout = 0;
        boolean strictMode = false;
        int connectionTimeout = 0;
        long httpConnectionTimeout = 0;
        HostConfiguration defaultHostConfiguration = null;

        /* access all synchronized data in a single block, this will keeps us
         * from accessing data asynchronously as well having to regain the lock
         * for each item.
         */
        synchronized (this) {
            soTimeout = this.timeoutInMilliseconds;
            strictMode = this.strictMode;
            connectionTimeout = this.connectionTimeout;
            httpConnectionTimeout = this.httpConnectionTimeout;
            if (state == null) {
                state = getState();
            }
            defaultHostConfiguration = getHostConfiguration();
        }

        HostConfiguration methodConfiguration 
            = new HostConfiguration(hostConfiguration);
        
        if (hostConfiguration != defaultHostConfiguration) {
            // we may need to apply some defaults
            if (!methodConfiguration.isHostSet()) {
                methodConfiguration.setHost(
                    defaultHostConfiguration.getHost(),
                    defaultHostConfiguration.getVirtualHost(),
                    defaultHostConfiguration.getPort(),
                    defaultHostConfiguration.getProtocol()
                );
            }
            if (!methodConfiguration.isProxySet() 
                && defaultHostConfiguration.isProxySet()) {
                    
                methodConfiguration.setProxy(
                    defaultHostConfiguration.getProxyHost(),
                    defaultHostConfiguration.getProxyPort() 
                );   
            }
            if (methodConfiguration.getLocalAddress() == null
                && defaultHostConfiguration.getLocalAddress() != null) {
                    
                methodConfiguration.setLocalAddress(defaultHostConfiguration.getLocalAddress());
            }
        }
        
        HttpConnectionManager connmanager = this.httpConnectionManager;
        if (state.getHttpConnectionManager() != null) {
            connmanager = state.getHttpConnectionManager();
        }

        HttpConnection connection = connmanager.getConnection(
            methodConfiguration,
            httpConnectionTimeout
        );

        try {
            // Catch all possible exceptions to make sure to release the 
            // connection, as although the user may call 
            // Method->releaseConnection(), the method doesn't know about the
            // connection until HttpMethod.execute() is called.
            
            method.setStrictMode(strictMode);
        
            if (!connection.isOpen()) {
                connection.setSoTimeout(soTimeout);
                connection.setConnectionTimeout(connectionTimeout);
                connection.open();
                if (connection.isProxied() && connection.isSecure()) {
                    method = new ConnectMethod(method);
                }
            }
        } catch (IOException e) {
            connection.releaseConnection();
            throw e;
        } catch (RuntimeException e) {
            connection.releaseConnection();
            throw e;
        }
        
        return method.execute(state, connection);
    }

    /**
     * @deprecated this method has no effect. HttpMethod.releaseConnection()
     * should be used to release resources after a HttpMethod has been executed.
     * 
     * @see HttpMethod#releaseConnection()
     */
    public void endSession() throws IOException {
    }

    /**
      * Return the host that the client is accessing.
      *
      * @return The host that the client is accessing, or <code>null</code> if
      * the session has not been started via startSession.
      */
     public String getHost() {
         return hostConfiguration.getHost();
     }

     /**
      * Return the port that the client is accessing.
      *
      * @return The port that the client is accessing, or -1 if the session
      * has not been started via startSession().
      */
     public int getPort() {
         return hostConfiguration.getPort();
     }
     
    /**
     * Returns the hostConfiguration.
     * @return HostConfiguration
     * 
     * @since 2.0
     */
    public synchronized HostConfiguration getHostConfiguration() {
        return hostConfiguration;
    }

    /**
     * Sets the hostConfiguration.
     * @param hostConfiguration The hostConfiguration to set
     * 
     * @since 2.0
     */
    public synchronized void setHostConfiguration(HostConfiguration hostConfiguration) {
        this.hostConfiguration = hostConfiguration;
    }

    /**
     * Returns the httpConnectionManager.
     * @return HttpConnectionManager
     * 
     * @since 2.0
     */
    public synchronized HttpConnectionManager getHttpConnectionManager() {
        return httpConnectionManager;
    }

    /**
     * Sets the httpConnectionManager.
     * @param httpConnectionManager The httpConnectionManager to set
     * 
     * @since 2.0
     */
    public synchronized void setHttpConnectionManager(
        HttpConnectionManager httpConnectionManager
    ) {
        this.httpConnectionManager = httpConnectionManager;
    }

}
