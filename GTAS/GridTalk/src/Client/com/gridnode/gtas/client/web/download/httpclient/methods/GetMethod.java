/*
 * $Header: /home/cvs/jakarta-commons/httpclient/src/java/org/apache/commons/httpclient/methods/GetMethod.java,v 1.24 2003/04/29 22:18:08 olegk Exp $
 * $Revision: 1.24 $
 * $Date: 2003/04/29 22:18:08 $
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

package com.gridnode.gtas.client.web.download.httpclient.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import com.gridnode.gtas.client.web.download.httpclient.HttpConnection;
import com.gridnode.gtas.client.web.download.httpclient.HttpException;
import com.gridnode.gtas.client.web.download.httpclient.HttpMethodBase;
import com.gridnode.gtas.client.web.download.httpclient.HttpState;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implements the HTTP GET specification.
 * <p>
 * The HTTP GET method is defined in section 8.1 of
 * <a href="http://www.ietf.org/rfc/rfc1945.txt">RFC1945</a>:
 * <blockquote>
 * The GET method means retrieve whatever information (in the form of an
 * entity) is identified by the Request-URI. If the Request-URI refers
 * to a data-producing process, it is the produced data which shall be
 * returned as the entity in the response and not the source text of the
 * process, unless that text happens to be the output of the process.
 * </blockquote>
 * </p>
 * <p>
 * GetMethods will follow redirect requests from the http server by default.
 * This behavour can be disabled by calling setFollowRedirects(false).</p>
 * <p>
 * The useDisk methods have been deprecated.  Disk I/O is the responsibility
 * of the client.  If you need to write a response body to a file, you
 * can use the following as an example:
 * <pre>
 *     out = new FileOutputStream(myFile);
 *     InputStream in = getResponseBodyAsStream();
 *     byte[] buffer = new byte[10000];
 *     int len ;
 *     while ((len = in.read(buffer)) > 0) {
 *        out.write(buffer, 0, len);
 *     }
 *     in.close();
 *     out.close();
 * </pre>
 * </p>
 *
 * @author <a href="mailto:remm@apache.org">Remy Maucherat</a>
 * @author Sung-Gu Park
 * @author Sean C. Sullivan
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 * @author <a href="mailto:jsdever@apache.org">Jeff Dever</a>
 * 
 * @version $Revision: 1.24 $
 * @since 1.0
 */
public class GetMethod extends HttpMethodBase {

    // -------------------------------------------------------------- Constants

    /** Log object for this class. */
    private static final Log LOG = LogFactory.getLog(GetMethod.class);

    /** 
     * Temporary directory.
     * @deprecated the client is responsible for disk I/O
     */
    private static final String TEMP_DIR = "temp/";


    // ----------------------------------------------------- Instance Variables

    /** 
     * File which contains the buffered data.
     * @deprecated the client is responsible for disk I/O
     */
    private File fileData;

    /** 
     * Temporary directory to use.
     * @deprecated the client is responsible for disk I/O
     */
    private String tempDir = TEMP_DIR;

    /** 
     * Temporary file to use.
     * @deprecated the client is responsible for disk I/O
     */
    private String tempFile = null;

    /** 
     * By default, the get method will buffer read data to the memory.
     * @deprecated the client is responsible for disk I/O
     */
    private boolean useDisk = false;


    // ----------------------------------------------------------- Constructors

    /**
     * No-arg constructor.
     * 
     * @since 1.0
     */
    public GetMethod() {
        setFollowRedirects(true);
    }

    /**
     * Constructor specifying a URI.
     *
     * @param uri either an absolute or relative URI
     * 
     * @since 1.0
     */
    public GetMethod(String uri) {
        super(uri);
        LOG.trace("enter GetMethod(String)");
        setFollowRedirects(true);
    }

    /**
     * Constructor.
     * 
     * @param path the path to request
     * @param tempDir the directory in which to store temporary files
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public GetMethod(String path, String tempDir) {
        super(path);
        LOG.trace("enter GetMethod(String, String)");
        setUseDisk(true);
        setTempDir(tempDir);
        setFollowRedirects(true);
    }

    /**
     * Constructor.
     * 
     * @param path the path to request
     * @param tempDir the directory in which to store temporary files
     * @param tempFile the file (under tempDir) to buffer contents to
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public GetMethod(String path, String tempDir, String tempFile) {
        super(path);
        LOG.trace("enter GetMethod(String, String, String)");
        setUseDisk(true);
        setTempDir(tempDir);
        setTempFile(tempFile);
        setFollowRedirects(true);
    }

    /**
     * Constructor.
     * 
     * @param path the path to request
     * @param fileData the file to buffer contents to
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public GetMethod(String path, File fileData) {
        this(path);
        LOG.trace("enter GetMethod(String, File)");
        useDisk = true;
        this.fileData = fileData;
        setFollowRedirects(true);
    }

    //~ Methods ииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииии

    /**
     * File data setter.
     * 
     * @param fileData the file to buffer data to
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public void setFileData(File fileData) {
        checkNotUsed();
        this.fileData = fileData;
    }

    /**
     * File data getter.
     * 
     * @return the file being used for buffering data
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public File getFileData() {
        return fileData;
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Returns <tt>"GET"</tt>.
     * 
     * @return <tt>"GET"</tt>
     * 
     * @since 2.0
     */
    public String getName() {
        return "GET";
    }

    /**
     * Temporary directory setter.
     * 
     * @param tempDir New value of tempDir
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public void setTempDir(String tempDir) {
        checkNotUsed();
        this.tempDir = tempDir;
        setUseDisk(true);
    }

    /**
     * Temporary directory getter.
     * 
     * @return the current temporary directory
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public String getTempDir() {
        return tempDir;
    }

    /**
     * Temporary file setter.
     * 
     * @param tempFile New value of tempFile
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public void setTempFile(String tempFile) {
        checkNotUsed();
        this.tempFile = tempFile;
    }

    /**
     * Temporary file getter.
     * 
     * @return the current temporary file
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public String getTempFile() {
        return tempFile;
    }

    // ------------------------------------------------------------- Properties

    /**
     * Buffer the response in a file or not. The default is false.
     * 
     * @param useDisk If true the entire response will be buffered in a
     *        temporary file.
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public void setUseDisk(boolean useDisk) {
        checkNotUsed();
        this.useDisk = useDisk;
    }

    /**
     * Tells if the response will be buffered in a file.
     * 
     * @return true if the response will be buffered
     * 
     * @deprecated the client is responsible for disk I/O
     * @since 1.0
     */
    public boolean getUseDisk() {
        return useDisk;
    }

    /**
     * Override recycle to reset redirects default.
     * 
     * @since 1.0
     */
    public void recycle() {
        LOG.trace("enter GetMethod.recycle()");

        super.recycle();
        this.fileData = null;
        setFollowRedirects(true);
    }

    // ----------------------------------------------------- HttpMethod Methods

    /**
     * Overrides method in {@link HttpMethodBase} to write data to the
     * appropriate buffer.
     * 
     * @param state the shared http state
     * @param conn the connection to read data from
     * 
     * @throws IOException when there are problems reading from the connection
     * @throws HttpException when a protocol error occurs or state is invalid
     * @since 2.0
     */
    protected void readResponseBody(HttpState state, HttpConnection conn)
    throws IOException, HttpException {
        LOG.trace("enter GetMethod.readResponseBody(HttpState, HttpConnection)");

        super.readResponseBody(state, conn);

        OutputStream out = null;
        if (useDisk) {
            out = new FileOutputStream(createTempFile());
            InputStream in = getResponseBodyAsStream();
            byte[] buffer = new byte[10000];
            int len ;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
            setResponseStream(new FileInputStream(createTempFile()));
        }
    }

    /**
     * Returns the file buffer, creating it if necessary. The created file is
     * deleted when the VM exits.
     * @return Temporary file to hold the data buffer.
     *
     * @deprecated the client is responsible for disk I/O
     */
    private File createTempFile() {
        if (fileData == null) {
            // Create a temporary file on the HD
            File dir = new File(tempDir);
            dir.deleteOnExit();
            dir.mkdirs();
            String tempFileName = null;
            if (tempFile == null) {
                String encodedPath = URLEncoder.encode(getPath());
                int length = encodedPath.length();
                if (length > 200) {
                    encodedPath =
                        encodedPath.substring(length - 190, length);
                }
                tempFileName = System.currentTimeMillis() + "-"
                    + encodedPath + ".tmp";
            } else {
                tempFileName = tempFile;
            }
            fileData = new File(tempDir, tempFileName);
 
            fileData = new File(tempDir, tempFileName);
            fileData.deleteOnExit();
        }
        return fileData;
    }
}
