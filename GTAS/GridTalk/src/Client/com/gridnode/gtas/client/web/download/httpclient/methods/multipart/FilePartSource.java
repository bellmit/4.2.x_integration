/*
 * $Header: /home/cvs/jakarta-commons/httpclient/src/java/org/apache/commons/httpclient/methods/multipart/FilePartSource.java,v 1.8 2003/03/11 19:54:48 olegk Exp $
 * $Revision: 1.8 $
 * $Date: 2003/03/11 19:54:48 $
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
 
package com.gridnode.gtas.client.web.download.httpclient.methods.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * A PartSource that reads from a File.
 * 
 * @author <a href="mailto:becke@u.washington.edu">Michael Becke</a>
 * @author <a href="mailto:mdiggory@latte.harvard.edu">Mark Diggory</a>
 * @author <a href="mailto:mbowler@GargoyleSoftware.com">Mike Bowler</a>
 *   
 * @since 2.0 
 */
public class FilePartSource implements PartSource {

    /** File part file. */
    private File file = null;

    /** File part file name. */
    private String fileName = null;
    
    /**
     * Constructor for FilePartSource.
     * 
     * @param file the FilePart source File. 
     *
     * @throws FileNotFoundException if the file does not exist or 
     * cannot be read
     */
    public FilePartSource(File file) throws FileNotFoundException {
        this.file = file;
        if (file != null) {
            if (!file.isFile()) {
                throw new FileNotFoundException("File is not a normal file.");
            }
            if (!file.canRead()) {
                throw new FileNotFoundException("File is not readable.");
            }
            this.fileName = file.getName();       
        }
    }

    /**
     * Constructor for FilePartSource.
     * 
     * @param fileName the file name of the FilePart
     * @param file the source File for the FilePart
     *
     * @throws FileNotFoundException if the file does not exist or 
     * cannot be read
     */
    public FilePartSource(String fileName, File file) 
      throws FileNotFoundException {
        this(file);
        if (fileName != null) {
            this.fileName = fileName;
        }
    }
    
    /**
     * Return the length of the file
     * @return the length of the file.
     * @see PartSource#getLength()
     */
    public long getLength() {
        if (this.file != null) {
            return this.file.length();
        } else {
            return 0;
        }
    }

    /**
     * Return the current filename
     * @return the filename.
     * @see PartSource#getFileName()
     */
    public String getFileName() {
        return (fileName == null) ? "noname" : fileName;
    }

    /**
     * Return a new {@link FileInputStream} for the current filename.
     * @return the new input stream.
     * @throws IOException If an IO problem occurs.
     * @see PartSource#createInputStream()
     */
    public InputStream createInputStream() throws IOException {
        if (this.file != null) {
            return new FileInputStream(this.file);
        } else {
            return new ByteArrayInputStream(new byte[] {});
        }
    }

}
