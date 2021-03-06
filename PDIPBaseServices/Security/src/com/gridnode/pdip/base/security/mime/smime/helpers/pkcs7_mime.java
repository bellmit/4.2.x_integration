package com.gridnode.pdip.base.security.mime.smime.helpers;
/**
 * <p>Title:  * This software is the proprietary information of GridNode Pte Ltd.
 * <p>Description: Peer Data Integration Platform
 * <p>Copyright: Copyright (c) 2001</p>
 * <p>Company: GridNode Pte Ltd</p>
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * 10 Nov 2003    Zou Qingsong        Created. *
 */
import java.awt.datatransfer.DataFlavor;
import java.io.*;

import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

public class pkcs7_mime implements DataContentHandler {

	/*
	 *
	 *  VARIABLES
	 *
	 */

    private static final ActivationDataFlavor ADF1;
    private static final DataFlavor[]         ADFs;

    public static final String PRIMARY_TYPE               = "application";
    public static final String SUB_TYPE                   = "pkcs7-mime";
    public static final String SMIME_TYPE_PARAM           = "smime-type";
    public static final String SIGNED_SMIME_TYPE_VALUE    = "signed-data";
    public static final String ENCRYPTED_SMIME_TYPE_VALUE = "enveloped-data";
    public static final String COMPRESSED_SMIME_TYPE_VALUE = "compressed-data";

	/*
	 *
	 *  CONSTRUCTORS
	 *
	 */

    static {
		ADF1  = new ActivationDataFlavor(MimeBodyPart.class, "application/pkcs7-mime", "Encrypted Data");
		ADFs = new DataFlavor[] { ADF1 };
	}

	/*
	 *
	 *  BUSINESS METHODS
	 *
	 */


	public Object getContent(DataSource _ds)
		throws IOException {

		try {
			byte[]                _buff = new byte[1024];
			BufferedInputStream   _bis  = new BufferedInputStream(_ds.getInputStream());
			ByteArrayOutputStream _baos = new ByteArrayOutputStream();
			BufferedOutputStream  _bos  = new BufferedOutputStream(_baos);
			int                   _len  = _bis.read(_buff, 0, 1024);
			while(_len > -1) {
				_bos.write(_buff, 0, _len);
				_len = _bis.read(_buff, 0, 1024);
			}

			_bis.close();
			_bos.close();

			return _baos.toByteArray();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Object getTransferData(DataFlavor _df, DataSource _ds)
		throws IOException {

		if (ADF1.equals(_df))
        {
			return getContent(_ds);
		}
		else {
			return null;
		}
	}

	public DataFlavor[] getTransferDataFlavors() {
		return ADFs;
	}

	public void writeTo(Object _obj, String _mimeType, OutputStream _os)
		throws IOException {

		if (_obj instanceof MimeBodyPart) {
			try {
				((MimeBodyPart)_obj).writeTo(_os);
			} catch (MessagingException ex) {
				throw new IOException(ex.getMessage());
			}
		}
		else if(_obj instanceof byte[]) {
			_os.write((byte[])_obj);
		}
        else if (_obj instanceof InputStream)
        {
            int         b;
            InputStream in = (InputStream)_obj;

            while ((b = in.read()) >= 0)
            {
                _os.write(b);
            }
        }
        else
        {
            throw new IOException("unknown object in writeTo " + _obj);
        }
	}

	/*
	 *
	 *  INTERNAL METHODS
	 *
	 */
	/*
	private boolean testMimeTypeIsEither(MimeType _mt) {
		if(!(PRIMARY_TYPE.equals(_mt.getPrimaryType()))) {
			return false;
		}

		if(!(SUB_TYPE.equals(_mt.getSubType()))) {
			return false;
		}

		return true;
	}*/
	/*
	private boolean testMimeTypeIsSigned(MimeType _mt)
        {
		if(!(testMimeTypeIsEither(_mt))) {
			return false;
		}

		return true;
	}

	private boolean testMimeTypeIsEncrypted(MimeType _mt)
        {
		if(!(testMimeTypeIsEither(_mt))) {
			return false;
		}

		return true;
	}*/
}
