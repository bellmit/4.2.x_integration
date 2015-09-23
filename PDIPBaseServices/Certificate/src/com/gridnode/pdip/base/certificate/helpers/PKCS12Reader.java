/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: PKCS12Reader.java
 *
 * ****************************************************************************
 * Date           Author              Changes
 * ****************************************************************************
 * 12 Oct 2001    Lim Soon Hsiung     Initial creation for GT 1.2
 * 07 Jun 2002    Jagadeesh           (GridTalk 2.0)Modified to include SecurityServicesException
 *                                    and Log Error Messages.
 * 03 Aug 2006    Tam Wei Xiang       Amend the way we access SecurityDB. This class
 *                                    is responsible for removing the provider itself.
 * Feb 09 2007		Alain Ah Ming				Log error codes or log warning message. 
 * Jun 29 2009    Tam Wei Xiang       #560: Migrate from RSA J-SAFE/B-SAFE to BouncyCastle Lib                                                                         
 */
package com.gridnode.pdip.base.certificate.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Vector;

import com.gridnode.pdip.base.certificate.exceptions.CertificateException;

/**
 * 
 * @author Lim Soon Hsiung
 * @since
 * @version GT 4.0 VAN
 */
public class PKCS12Reader
{
//  private String sampleCert = "sample.p12";
//  private String pw = "Gridnode1!";
  private String pkcs12Filename;
  private char[] password;
//  private DatabaseService dbService;
//  private CertJ certJ;
  //private JSAFE_PublicKey pubkey;
//  private JSAFE_PrivateKey ptekey;
  private PrivateKey _privateKey;
  
//  private X509Certificate subjectCert;
  private java.security.cert.X509Certificate _subjectCert;

  //private JSAFE_PrivateKey[] pteKeys;
//  private X509Certificate[] certificates;
  private java.security.cert.X509Certificate[] _certificates;
  
  private String serviceName;
  private boolean isInitialized = false;
  
  private SecurityDB _secDB = null; //TWX 03082006
  
  public PKCS12Reader(String pkcs12Filename, char[] password)
  {
    this.pkcs12Filename = pkcs12Filename;
    this.password = password;
  }

  public void read() throws CertificateException
  {
    try
    {
      KeyStore keyStore = loadFile(pkcs12Filename);
      loadCerts(keyStore);
      loadPteKeys(keyStore);

      findSubjectCert();
      checkKeyMatch();
    }
    catch (CertificateException seEx)
    {
      CertificateLogger.warn("Exception in read "+seEx.getMessage());
      throw seEx;
    }
    catch (Exception ex)
    {
      CertificateLogger.warn("Exception in Read ");
      throw new CertificateException("Exception in Read ",ex);
    }
  }
  
  public static void main(String[] args) throws Exception
  {
    File p12 = new File("c:/sample.p12");
    FileInputStream input = new FileInputStream(p12);
    
    KeyStore key = KeyStore.getInstance("PKCS12", "BC");
    key.load(input, "password".toCharArray());
    
    Enumeration en = key.aliases();
    while(en.hasMoreElements())
    {
      String alieas = (String)en.nextElement();
      java.security.cert.X509Certificate cert = (java.security.cert.X509Certificate)key.getCertificate(alieas);
      System.out.println("Cert: "+ alieas);
      //System.out.println("Cert info: "+cert.getIssuerX500Principal().getName());
    }
    
    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)key.getEntry("privateKeyAlias", new KeyStore.PasswordProtection("password".toCharArray()));
    //PrivateKey myPrivateKey = pkEntry.getPrivateKey();
    //System.out.println("Private key:"+myPrivateKey);
    
    PKCS12Reader reader = new PKCS12Reader(p12.getAbsolutePath(), "password".toCharArray());
    reader.read();
    
    //reader.read();
  }
  
  private void checkKeyMatch() throws CertificateException
  {
    if(_subjectCert == null || _privateKey == null)
    {
      return;
    }
      
    if(!GridCertUtilities.isMatchingPair(_subjectCert, _privateKey))
      throw new CertificateException("Certificate and private key is not a matching pair");
  }
  
  private void findSubjectCert()
  {
    CertificateLogger.log("findSubjectCert Searching for subject key .....");

    CertVerifier cv = new CertVerifier();
    int count = _certificates.length;
    boolean found = true;
    
    for (int i = 0; i < count; i++)
    {
      found = true;
      cv.setIssuerCert(_certificates[i]);
      for (int j = 0; j < count; j++)
      {
        if(i == j)
          continue;
        cv.setSubjectCert(_certificates[j]);    
        try
        {
          if(cv.isIssuedBy() == CertVerifier.ERR_NO_ERROR)
          {
            found = false;
          }
        }
        catch (Exception ex)
        {

        }
      }// end of for j

      if(found)
      {
        _subjectCert = _certificates[i];
        break;
      }
    }// end of for i

    CertificateLogger.log("findSubjectCert End searching for subject key ....."+_subjectCert);
  }
  
  private KeyStore loadFile(String filename)
    throws CertificateException
  {
    KeyStore keystore = null;
    FileInputStream in = null;
    try
    {   
      CertificateLogger.log("Instantiating keystore. File: " +filename);
      in = new FileInputStream(new File(filename));
      keystore = KeyStore.getInstance("PKCS12", GridCertUtilities.getSecurityProvider());
      keystore.load(in, password);
      CertificateLogger.log("load PKCS12 file Done.");
      return keystore;
    }
    catch (Exception ex)
    {
      CertificateLogger.warn("Exception creating PKCS12 object");
      throw new CertificateException("Unable to load PKCS12 Object:  ",ex);
    }
    finally
    {
      if(in != null)
      {
        try
        {
          in.close();
        }
        catch(IOException ioex)
        {
          ioex.printStackTrace();
        }
      }
    }
  }
  
  public PrivateKey getPrivateKey()
  {
    return _privateKey;
  }

  public java.security.cert.X509Certificate getCertificate()
  {
    return _subjectCert;
  }
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }

  private void loadCerts(KeyStore keyStore) throws CertificateException
  {

    CertificateLogger.log("loadCerts Loading cert.....");
    Vector<java.security.cert.X509Certificate> res = new Vector<java.security.cert.X509Certificate>();

    try
    {
      
      Enumeration<String> aliases = keyStore.aliases();
     
      while (aliases.hasMoreElements())
      {
        String certAlias = aliases.nextElement();

        Certificate cert = keyStore.getCertificate(certAlias);
        if(cert instanceof java.security.cert.X509Certificate)
        {
          res.add((java.security.cert.X509Certificate)cert);
          CertificateLogger.debug("PKCS12Reader: Load Certificate:"+((java.security.cert.X509Certificate)cert));
        }
        else
        {
            CertificateLogger.debug("Non X509Certificate found: "+cert+". ignored");
        }
      }
      CertificateLogger.log("loadCerts Done loading cert, count: " + res.size());
      _certificates = new java.security.cert.X509Certificate[res.size()];
      _certificates = (java.security.cert.X509Certificate[])res.toArray(_certificates);

    }
    catch (Exception ex)
    {
      CertificateLogger.warn("loadCerts Excepton ");
      throw new CertificateException("loadCerts Excepton ",ex);
    }


  }
  
  private void loadPteKeys(KeyStore keyStore) throws CertificateException
  {
    CertificateLogger.log("loadPteKeys Loading private key .....");
    try
    {
      Enumeration<String> aliases = keyStore.aliases();
      while(aliases.hasMoreElements())
      {
        String alias = aliases.nextElement();
        boolean isKeyEntry = keyStore.isKeyEntry(alias);
        if(isKeyEntry)
        {
          Key key = keyStore.getKey(alias, password);
          if(key instanceof PrivateKey)
          {
            _privateKey = (PrivateKey)key;
            break;
          }
        }
      }

      CertificateLogger.log("loadPteKeys Done loading private key .....");
    }
    catch (Exception ex)
    {
      CertificateLogger.warn("loadPteKeys Exception ");
      throw new CertificateException("loadPteKeys Exception ",ex);
    }
  }
  
//TWX 03082006
  public void setSecurityDB(SecurityDB secDB)
  {
  	_secDB = secDB;
  }
  
  public SecurityDB getSecurityDB()
  {
  	return _secDB;
  }
  
//  public void removeProvider(String serviceName)
//  	throws ProviderManagementException, InvalidParameterException
//  {
//  	if(_secDB != null)
//  	{
//  		CertJ certJ = _secDB.getCertJ();
//  		certJ.removeProvider(CertJ.SPT_DATABASE, serviceName);
//  	}
//  }
  //end
  
// Logging methods ***********************************************************
//  public static void log(String methodName, String msg)
//  {
//    System.out.println("LOG [PKCS12Reader." + methodName + "] " + msg);
//  }
//  public static void debug(String methodName, String msg)
//  {
//    System.out.println("DEBUG [PKCS12Reader." + methodName + "] " + msg);
//  }
//  public static void err(String methodName, String msg, Exception ex)
//  {
//    System.out.println("ERR [PKCS12Reader." + methodName + "] " + msg);
//    ex.printStackTrace();
//  }


//  public static void main (String[] args)
//    throws Exception
//  {
//    try
//    {
//
//      PKCS12Reader reader = new PKCS12Reader ("gridnodecert.pfx", "".toCharArray());
//      reader.read ();
//      System.out.println("Cert: " + reader.getCertificate());
//      System.out.println("pk: " + reader.getPrivateKey());
//    CertUtilities.writeX509Certificate("nettrustgridnode.cer", reader.getCertificate());
//    CertUtilities.writePKCS8PrivateKey("nettrustgridnode.prv", reader.getPrivateKey(), reader);

//    PKCS12Reader reader2 = new PKCS12Reader ("sample.p12", "Gridnode1!".toCharArray());
//    reader2.read ();
//    CertUtilities.writeX509Certificate("idsafegridnodepw.cer", reader2.getCertificate());
//    CertUtilities.writePKCS8PrivateKey("idsafegridnode.prv", reader2.getPrivateKey(), reader);
//    }
//    catch (Exception ex)
//    {
//      ex.printStackTrace();
//    }
//  }
}
