SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;
SET search_path = appdb;

DELETE FROM "entitymetainfo" WHERE "EntityName" IN ('Certificate', 'CertificateSwapping');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.base.certificate.model.Certificate','Certificate','"certificate"');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.base.certificate.model.CertificateSwapping','CertificateSwapping','');

--------- Certificate
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%Certificate';
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.base.certificate.model.Certificate','certificate.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=uid'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_privateKey','PRIVATEKEY','"PrivateKey"','java.lang.String','com.gridnode.pdip.base.certificate.model.Certificate','certificate.privateKey',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_publicKey','PUBLICKEY','"PublicKey"','java.lang.String','com.gridnode.pdip.base.certificate.model.Certificate','certificate.publicKey',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_certificate','CERTIFICATE','"Certificate"','java.lang.String','com.gridnode.pdip.base.certificate.model.Certificate','certificate.certificate',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_issuerName','ISSUERNAME','"IssuerName"','java.lang.String','com.gridnode.pdip.base.certificate.model.Certificate','certificate.issuerName',120,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_serialNum','SERIALNUM','"SerialNum"','java.lang.String','com.gridnode.pdip.base.certificate.model.Certificate','certificate.serialNum',30,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.base.certificate.model.Certificate','certificate.name',50,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=50'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_id','ID','"ID"','java.lang.Integer','com.gridnode.pdip.base.certificate.model.Certificate','certificate.id',20,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=range'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_revokeID','REVOKEID','"RevokeID"','java.lang.Integer','com.gridnode.pdip.base.certificate.model.Certificate','certificate.revokeId',11,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=range'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isMaster','IS_MASTER','"isMaster"','java.lang.Boolean','com.gridnode.pdip.base.certificate.model.Certificate','certificate.isMaster',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isPartner','IS_PARTNER','"isPartner"','java.lang.Boolean','com.gridnode.pdip.base.certificate.model.Certificate','certificate.isPartner',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_category','CATEGORY','"Category"','java.lang.Short','com.gridnode.pdip.base.certificate.model.Certificate','certificate.category',80,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=enum');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isInKeyStore','IS_IN_KS','"iSINKS"','java.lang.Boolean','com.gridnode.pdip.base.certificate.model.Certificate','certificate.inKeyStore',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isInTrustStore','IS_IN_TS','"iSINTS"','java.lang.Boolean','com.gridnode.pdip.base.certificate.model.Certificate','certificate.inTrustStore',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_relatedCertUid','RELATED_CERT_UID','"relatedCertUid"','java.lang.Long','com.gridnode.pdip.base.certificate.model.Certificate','certificate.relatedCertUid',0,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=foreign'||chr(13)||chr(10)||'foreign.key=certificate.uid'||chr(13)||chr(10)||'foreign.display=certificate.name'||chr(13)||chr(10)||'foreign.cached=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_startDate','START_DATE','"StartDate"','java.util.Date','com.gridnode.pdip.base.certificate.model.Certificate','certificate.startDate',0,0,0,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=datetime'||chr(13)||chr(10)||'datetime.time=true'||chr(13)||chr(10)||'datetime.date=true'||chr(13)||chr(10)||'datetime.adjustment=gts');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_endDate','END_DATE','"EndDate"','java.util.Date','com.gridnode.pdip.base.certificate.model.Certificate','certificate.endDate',0,0,0,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=datetime'||chr(13)||chr(10)||'datetime.time=true'||chr(13)||chr(10)||'datetime.date=true'||chr(13)||chr(10)||'datetime.adjustment=gts');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_isCA','IS_CA','"IsCA"','java.lang.Boolean','com.gridnode.pdip.base.certificate.model.Certificate','certificate.isCA',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_replacementCertUid','REPLACEMENT_CERT_UID','"ReplacementCertUid"','java.lang.Long','com.gridnode.pdip.base.certificate.model.Certificate','certificate.replacementCertUid',0,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=foreign'||chr(13)||chr(10)||'foreign.key=certificate.uid'||chr(13)||chr(10)||'foreign.display=certificate.name'||chr(13)||chr(10)||'foreign.cached=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_certificateSwapping','CERTIFICATE_SWAPPING','','com.gridnode.pdip.base.certificate.model.CertificateSwapping','com.gridnode.pdip.base.certificate.model.Certificate','certificate.certificateSwapping',0,1,0,1,0,'0',999,'','type=embedded'||chr(13)||chr(10)||'embedded.type=certificateSwapping'||chr(13)||chr(10));

--------- CertificateSwapping
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%CertificateSwapping';
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_uId','UID','','java.lang.Long','com.gridnode.pdip.base.certificate.model.CertificateSwapping','certificateSwapping.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=uid'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_swapDate','SWAP_DATE','','java.util.Date','com.gridnode.pdip.base.certificate.model.CertificateSwapping','certificateSwapping.swapDate',0,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=datetime'||chr(13)||chr(10)||'datetime.time=false'||chr(13)||chr(10)||'datetime.date=true'||chr(13)||chr(10)||'datetime.pattern=yyyy-MM-dd'||chr(13)||chr(10)||'text.length.max=10');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_swapTime','SWAP_TIME','','java.lang.String','com.gridnode.pdip.base.certificate.model.CertificateSwapping','certificateSwapping.swapTime',5,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=5');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_alarmUID','ALARM_UID','','java.lang.Long','com.gridnode.pdip.base.certificate.model.CertificateSwapping','certificateSwapping.alarmUid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=uid'||chr(13)||chr(10));
