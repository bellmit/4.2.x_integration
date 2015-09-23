SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;
SET search_path = appdb;

DELETE FROM "entitymetainfo" WHERE "EntityName" IN ('RegistrationInfo','GridTalkLicense');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.gtas.server.registration.model.RegistrationInfo','RegistrationInfo',NULL);
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.gtas.server.registration.model.GridTalkLicense','GridTalkLicense','"gridtalk_license"');

---------- RegistrationInfo
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%RegistrationInfo';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_nodeID','GRIDNODE_ID',NULL,'java.lang.Integer','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.gridnodeId',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=range'||chr(13)||chr(10)||'range.min=1'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_nodeName','GRIDNODE_NAME',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.gridnodeName',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=64'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_prodKeyF1','PRODUCT_KEY_F1',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.prodKeyF1',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.min=5'||chr(13)||chr(10)||'text.length.max=5'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_prodKeyF2','PRODUCT_KEY_F2',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.prodKeyF2',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.min=6'||chr(13)||chr(10)||'text.length.max=6'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_prodKeyF3','PRODUCT_KEY_F3',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.prodKeyF3',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.min=5'||chr(13)||chr(10)||'text.length.max=5'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_prodKeyF4','PRODUCT_KEY_F4',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.prodKeyF4',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.min=6'||chr(13)||chr(10)||'text.length.max=6'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_category','CATEGORY',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.category',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=foreign'||chr(13)||chr(10)||'foreign.key=gnCategory.code'||chr(13)||chr(10)||'foreign.display=gnCategory.name'||chr(13)||chr(10)||'foreign.cached=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_profile','COMPANY_PROFILE',NULL,'com.gridnode.pdip.app.coyprofile.model.CompanyProfile','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.companyProfile',0,0,0,1,1,NULL,999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=embedded'||chr(13)||chr(10)||'embedded.type=coyProfile'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_licStartDate','LIC_START_DATE',NULL,'java.util.Date','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.licStartDate',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=datetime'||chr(13)||chr(10)||'datetime.date=true'||chr(13)||chr(10)||'datetime.time=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_licEndDate','LIC_END_DATE',NULL,'java.util.Date','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.licEndDate',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=datetime'||chr(13)||chr(10)||'datetime.date=true'||chr(13)||chr(10)||'datetime.time=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_bizConnections','BIZ_CONNECTIONS',NULL,'java.lang.Integer','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.bizConnections',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=range'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_registrationState','REGISTRATION_STATE',NULL,'java.lang.Short','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.registrationState',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'registrationInfo.registrationState.notRegistered=0'||chr(13)||chr(10)||'registrationInfo.registrationState.registered=1'||chr(13)||chr(10)||'registrationInfo.registrationState.regInProgress=2'||chr(13)||chr(10)||'registrationInfo.registrationState.expired=3'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_licFile','LICENSE_FILE',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.licFile',0,0,0,1,1,NULL,999,'||chr(13)||chr(10)displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.update=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=file'||chr(13)||chr(10)||'file.downloadable=false'||chr(13)||chr(10)||'file.pathKey=registration.path.license'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_osName','OS_NAME',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.osName',0,0,0,1,1,NULL,999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_osVersion','OS_VERSION',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.osVersion',0,0,0,1,1,NULL,999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_machineName','MACHINE_NAME',NULL,'java.lang.String','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.machineName',0,0,0,1,1,NULL,999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_licenseState','LICENSE_STATE',NULL,'java.lang.Short','com.gridnode.gtas.server.registration.model.RegistrationInfo','registrationInfo.licenseState',0,0,0,1,1,NULL,999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'registrationInfo.licenseState.valid=0'||chr(13)||chr(10)||'registrationInfo.licenseState.notCommenced=1'||chr(13)||chr(10)||'registrationInfo.licenseState.expired=2'||chr(13)||chr(10)||'registrationInfo.licenseState.revoked=3'||chr(13)||chr(10));

---------- GridTalkLicense
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%GridTalkLicense';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.gtas.server.registration.model.GridTalkLicense','gridTalkLicense.uid',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.gtas.server.registration.model.GridTalkLicense','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.gtas.server.registration.model.GridTalkLicense','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'candelete.enabled=true'||chr(13)||chr(10)||'candelete.disabled=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_licenseUid','LICENSE_UID','"LicenseUid"','java.lang.Long','com.gridnode.gtas.server.registration.model.GridTalkLicense','gridTalkLicense.licenseUid',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false','type=foreign'||chr(13)||chr(10)||'foreign.key=license.uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_osName','OS_NAME','"OsName"','java.lang.String','com.gridnode.gtas.server.registration.model.GridTalkLicense','gridTalkLicense.osName',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_osVersion','OS_VERSION','"OsVersion"','java.lang.String','com.gridnode.gtas.server.registration.model.GridTalkLicense','gridTalkLicense.osVersion',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_machineName','MACHINE_NAME','"MachineName"','java.lang.String','com.gridnode.gtas.server.registration.model.GridTalkLicense','gridTalkLicense.machineName',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_startDate','START_DATE','"StartDate"','java.lang.String','com.gridnode.gtas.server.registration.model.GridTalkLicense','gridTalkLicense.startDate',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_endDate','END_DATE','"EndDate"','java.lang.String','com.gridnode.gtas.server.registration.model.GridTalkLicense','gridTalkLicense.endDate',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false','type=text');
