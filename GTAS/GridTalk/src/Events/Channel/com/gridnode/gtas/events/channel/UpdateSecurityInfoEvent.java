/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: UpdateSecurityInfoEvent.java
 *
 ****************************************************************************
 * Date           Author                  Changes
 ****************************************************************************
 * Aug 27 2002    Jagadeesh               Created
 * Oct 04 2002    Ang Meng Hua            Removed RefID, isPartner, PartnerCategoty
 *                                        and isDisable from event constructor
 * Nov 23 2003    Guo Jianyu              Added support for compression
 * Nov 26 2003    Guo Jianyu              Added encryptionALgorithm
 */


package com.gridnode.gtas.events.channel;


import com.gridnode.pdip.framework.rpf.event.EventException;
import com.gridnode.pdip.framework.rpf.event.EventSupport;

/**
 * This event class contains the data for Updating  of a PackagingInfo.
 *
 *
 * @author Jagadeesh.
 *
 * @version 2.0
 * @since 2.0
 */


public class UpdateSecurityInfoEvent extends EventSupport
{


  /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4365947548331315943L;


	/**
   * FieldId for UId.
   */
  public static final String UID = "uId";


  /**
   * FieldId for Name.
   */
  public static final String NAME = "Name"; // varchar(30)

  /**
   * FieldId for Description.
   */
  public static final String DESCRIPTION = "Description"; // varchar(80)

  /**
   * FieldId for Encryption Type.
   */

  public static final String ENCRYPTION_TYPE = "EncryptionType"; // varchar(80)

  /**
   * FieldId for Encryption Level.
   */

  public static final String ENCRYPTION_LEVEL = "EncryptionLevel"; // varchar(80)

  /**
   * FieldId for Encryption Certificate.
   */

  public static final String ENCRYPTION_CERTIFICATE_ID = "EncryptionCertificate"; // varchar(80)

  /**
   * FieldId for Signature Type.
   */

  public static final String SIGNATURE_TYPE = "SignatureType"; // varchar(80)

  /**
   * FieldId for Digest Algorithm.
   */

  public static final String DIGEST_ALGORITHM ="DigestAlgorithm"; // varchar(80)

  /**
   * FieldId for SignatureEncryption Certificate.
   */

  public static final String SIGNATURE_ENCRYPTION_CERTIFICATE_ID = "SignatureEncryptionCertificaate"; // varchar(80)

  /**
   * FieldId for compression Type. A String.
   */
  public static final String COMPRESSION_TYPE = "CompressionType";

  /**
   * FieldId for compression method.
   */
  public static final String COMPRESSION_METHOD = "CompressionMethod";

  /**
   * FieldId for Encryption Level.
   */
  public static final String COMPRESSION_LEVEL = "CompressionLevel";

  /**
   * FieldId for sequence.
   */
  public static final String SEQUENCE = "Sequence";

  /**
   * FieldId for encryptionAlgorithm
   */
  public static final String ENCRYPTION_ALGORITHM = "EncryptionAlgorithm";

  public UpdateSecurityInfoEvent(
    Long uId,
    String name,
    String description,
    String encryptionType,
    Integer encryptionLevel,
    Long encryptionCertificate,
    String signatureType,
    String digestAlgorithm,
    Long signatureEncyptCertificate,
    String compressionType,
    String compressionMethod,
    Integer compressionLevel,
    String sequence,
    String encryptionAlgorithm)
    throws EventException
  {
    setEventData(UID, uId);
    setEventData(NAME, name);
    setEventData(DESCRIPTION, description);
    setEventData(ENCRYPTION_TYPE, encryptionType);
    setEventData(ENCRYPTION_LEVEL, encryptionLevel);
//    checkSetObject(ENCRYPTION_LEVEL, encryptionLevel,Integer.class);
    setEventData(ENCRYPTION_CERTIFICATE_ID,encryptionCertificate);
//    checkSetObject(ENCRYPTION_CERTIFICATE_ID,encryptionCertificate,Long.class);
    setEventData(SIGNATURE_TYPE, signatureType);
    setEventData(DIGEST_ALGORITHM, digestAlgorithm);
    setEventData(SIGNATURE_ENCRYPTION_CERTIFICATE_ID,signatureEncyptCertificate);
//    checkSetObject(SIGNATURE_ENCRYPTION_CERTIFICATE_ID,signatureEncyptCertificate,Long.class);
    setEventData(COMPRESSION_TYPE, compressionType);
    setEventData(COMPRESSION_METHOD, compressionMethod);
    setEventData(COMPRESSION_LEVEL, compressionLevel);
    setEventData(SEQUENCE, sequence);
    setEventData(ENCRYPTION_ALGORITHM, encryptionAlgorithm);
  }


  public String getName()
  {
    return (String)getEventData(NAME);
  }

  public String getDescription()
  {
    return (String)getEventData(DESCRIPTION);
  }

  public String getEncryptionType()
  {
    return (String)getEventData(ENCRYPTION_TYPE);
  }

  public int getEncryptionLevel()
  {
    return ((Integer)getEventData(ENCRYPTION_LEVEL)).intValue();
  }

  public Long getEncyptionCertificateID()
  {
    return (Long)getEventData(ENCRYPTION_CERTIFICATE_ID);
  }

  public String getSignatureType()
  {
    return (String)getEventData(SIGNATURE_TYPE);
  }

  public String getDigestAlgorithm()
  {
    return (String)getEventData(DIGEST_ALGORITHM);
  }

  public Long getSignatureEncyptCertificateID()
  {
    return (Long)getEventData(SIGNATURE_ENCRYPTION_CERTIFICATE_ID);
  }

  public String getCompressionType()
  {
    return (String)getEventData(COMPRESSION_TYPE);
  }

  public String getCompressionMethod()
  {
    return (String)getEventData(COMPRESSION_METHOD);
  }

  public Integer getCompressionLevel()
  {
    return (Integer)getEventData(COMPRESSION_LEVEL);
  }

  public String getSequence()
  {
    return (String)getEventData(SEQUENCE);
  }

  public String getEncryptionAlgorithm()
  {
    return (String)getEventData(ENCRYPTION_ALGORITHM);
  }

  public Long getUId()
  {
    return (Long) getEventData(UID);
  }

  public String getEventName()
  {
    return "java:comp/env/param/event/UpdateSecurityInfoEvent";
  }
}


