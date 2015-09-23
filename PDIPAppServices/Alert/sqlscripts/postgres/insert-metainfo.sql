SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;
SET search_path = appdb;


DELETE FROM "entitymetainfo" WHERE "EntityName" IN ('Alert','AlertType','Action','MessageTemplate','AlertAction','AlertCategory','AlertList','EmailConfig','JmsDestination','MessageProperty','JmsMessageRecord');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.Alert','Alert','"alert"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.AlertType','AlertType','"alert_type"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.Action','Action','"action"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.MessageTemplate','MessageTemplate','"message_template"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.AlertAction','AlertAction','"alert_action"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.AlertCategory','AlertCategory','"alert_category"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.AlertList','AlertList','"alert_list"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.EmailConfig','EmailConfig',NULL);
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.JmsDestination','JmsDestination','"jms_destination"');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.MessageProperty','MessageProperty','');
INSERT INTO "entitymetainfo" VALUES('com.gridnode.pdip.app.alert.model.JmsMessageRecord','JmsMessageRecord','"jms_msg_record"');

--------- Alert
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.Alert';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_trigger','TRIGGER','"TriggerCond"','java.lang.String','com.gridnode.pdip.app.alert.model.Alert','alert.trigger',2000,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=2000');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_categoryUid','CATEGORY_UID','"Category"','java.lang.Long','com.gridnode.pdip.app.alert.model.Alert','alert.category',20,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=foreign'||chr(13)||chr(10)||'foreign.key=alertCategory.uid'||chr(13)||chr(10)||'foreign.cached=false'||chr(13)||chr(10)||'foreign.display=alertCategory.code');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.alert.model.Alert','alert.name',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_alertTypeUid','ALERT_TYPE_UID','"AlertType"','java.lang.Long','com.gridnode.pdip.app.alert.model.Alert','alert.type',20,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=foreign'||chr(13)||chr(10)||'foreign.key=alertType.uid'||chr(13)||chr(10)||'foreign.display=alertType.description'||chr(13)||chr(10)||'foreign.cached=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.Alert','alert.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.alert.model.Alert','alert.description',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_bindActions','BIND_ACTIONS_UIDS','','java.util.Collection','com.gridnode.pdip.app.alert.model.Alert','alert.actions',0,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','collection=true'||chr(13)||chr(10)||'collection.element=java.lang.Long'||chr(13)||chr(10)||'type=foreign'||chr(13)||chr(10)||'foreign.key=action.uid'||chr(13)||chr(10)||'foreign.display=action.name'||chr(13)||chr(10)||'foreign.cached=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.Alert','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.Alert','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');

--------- Action
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.Action';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.alert.model.Action','action.description',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_msgUid','MSG_UID','"MsgUid"','java.lang.Long','com.gridnode.pdip.app.alert.model.Action','action.msgId',20,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=foreign'||chr(13)||chr(10)||'foreign.key=messageTemplate.uid'||chr(13)||chr(10)||'foreign.display=messageTemplate.name'||chr(13)||chr(10)||'foreign.cached=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.Action','action.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.alert.model.Action','action.name',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.Action','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.Action','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');

--------- MessageTemplate
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.MessageTemplate';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_toaddr','TOADDR','"ToAddr"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.toAddr',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_fromaddr','FROMADDR','"FromAddr"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.fromAddr',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','type=text'||chr(13)||chr(10)||'text.max.length=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_messageType','MESSAGETYPE','"MessageType"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.messageType',30,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=enum'||chr(13)||chr(10)||'messageTemplate.messageType.email=EMail'||chr(13)||chr(10)||'messageTemplate.messageType.log=Log'||chr(13)||chr(10)||'messageTemplate.messageType.alertList=AlertList'||chr(13)||chr(10)||'messageTemplate.messageType.JMS=JMS');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_contentType','CONTENTTYPE','"ContentType"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.contentType',30,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=enum'||chr(13)||chr(10)||'messageTemplate.contentType.text=Text'||chr(13)||chr(10)||'messageTemplate.contentType.html=HTML');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.name',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_ccAddr','CCADDR','"CcAddr"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.ccAddr',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_subject','SUBJECT','"Subject"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.subject',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_message','MESSAGE','"Message"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.message',2000,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=2000');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_location','LOCATION','"Location"','java.lang.String','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.location',255,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_append','APPEND','"Append"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.append',1,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.MessageTemplate','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.MessageTemplate','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_jmsDestination','JMS_DESTINATION','"JmsDestination"','com.gridnode.pdip.app.alert.model.JmsDestination','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.jmsDestination',20,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=foreign'||chr(13)||chr(10)||'foreign.key=jmsDestination.uid'||chr(13)||chr(10)||'foreign.display=jmsDestination.name'||chr(13)||chr(10)||'foreign.cached=true');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_messageProperties','MESSAGE_PROPERTIES','"MessageProperties"','DataObjectList','com.gridnode.pdip.app.alert.model.MessageTemplate','messageTemplate.messageProperties',0,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','type=embedded'||chr(13)||chr(10)||'embedded.type=messageProperty'||chr(13)||chr(10)||'collection=true');

--------- AlertAction
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.AlertAction';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_actionUid','ACTION_UID','"ActionUid"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertAction','alertAction.actionUid',20,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=foreign'||chr(13)||chr(10)||'foreign.key=action.uid'||chr(13)||chr(10)||'foreign.display=action.name'||chr(13)||chr(10)||'foreign.cached=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertAction','alertAction.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_alertUid','ALERT_UID','"AlertUid"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertAction','alertAction.alertUid',20,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=foreign'||chr(13)||chr(10)||'foreign.key=alert.uid'||chr(13)||chr(10)||'foreign.display=alert.name'||chr(13)||chr(10)||'foreign.cached=false');

--------- AlertCategory
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.AlertCategory';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertCategory','alertCategory.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_code','CODE','"Code"','java.lang.String','com.gridnode.pdip.app.alert.model.AlertCategory','alertCategory.code',20,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true','type=text'||chr(13)||chr(10)||'text.length.max=20');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.alert.model.AlertCategory','alertCategory.name',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.alert.model.AlertCategory','alertCategory.description',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.AlertCategory','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.AlertCategory','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');

--------- AlertList
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.AlertList';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertList','alertList.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_userUid','USER_UID','"UserUid"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertList','alertList.userUid',20,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_from_uid','FROM_UID','"FromUid"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertList','alertList.fromUid',20,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_title','TITLE','"Title"','java.lang.String','com.gridnode.pdip.app.alert.model.AlertList','alertList.title',35,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_message','MESSAGE','"Message"','java.lang.String','com.gridnode.pdip.app.alert.model.AlertList','alertList.message','1024',0,0,1,1,0,'999','displayabletrue'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_readstatus','READSTATUS','"ReadStatus"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.AlertList','alertList.readStatus',1,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_date','DATE','"Date"','java.util.Date','com.gridnode.pdip.app.alert.model.AlertList','alertList.date',20,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false','type=text');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.AlertList','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.AlertList','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');

--------- AlertType
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.AlertType';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.AlertType','alertType.uid',20,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.alert.model.AlertType','alertType.name',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.alert.model.AlertType','alertType.description',255,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.AlertType','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.AlertType','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');

--------- EmailConfig
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%EmailConfig';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_smtpServerHost','SMTP_SERVER_HOST',NULL,'java.lang.String','com.gridnode.pdip.app.alert.model.EmailConfig','emailConfig.smtpServerHost',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_smtpServerPort','SMTP_SERVER_PORT',NULL,'java.lang.Long','com.gridnode.pdip.app.alert.model.EmailConfig','emailConfig.smtpServerPort',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_authUser','AUTH_USER',NULL,'java.lang.String','com.gridnode.pdip.app.alert.model.EmailConfig','emailConfig.authUser',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_authPassword','AUTH_PASSWORD',NULL,'java.lang.String','com.gridnode.pdip.app.alert.model.EmailConfig','emailConfig.authPassword',80,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_retryInterval','RETRY_INTERVAL',NULL,'java.lang.Long','com.gridnode.pdip.app.alert.model.EmailConfig','emailConfig.retryInterval',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=range'||chr(13)||chr(10)||'range.min=180');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_maxRetries','MAX_RETRIES',NULL,'java.lang.Integer','com.gridnode.pdip.app.alert.model.EmailConfig','emailConfig.maxRetries',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_saveFailedEmails','SAVE_FAILED_EMAILS',NULL,'java.lang.Boolean','com.gridnode.pdip.app.alert.model.EmailConfig','emailConfig.saveFailedEmails',0,0,0,1,1,NULL,999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');

--------- jms_destination
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%JmsDestination';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.uid',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.JmsDestination','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.JmsDestination','',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'candelete.enabled=true'||chr(13)||chr(10)||'candelete.disabled=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.name',30,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_type','TYPE','"Type"','java.lang.Integer','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.type',1,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'jmsDestination.type.queue=1'||chr(13)||chr(10)||'jmsDestination.type.topic=2');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_jndiName','JNDI_NAME','"JndiName"','java.lang.String','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.jndiName',255,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_deliveryMode','DELIVERY_MODE','"DeliveryMode"','java.lang.Integer','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.deliveryMode',2,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'jmsDestination.deliveryMode.Default=0'||chr(13)||chr(10)||'jmsDestination.deliveryMode.Persistent=1'||chr(13)||chr(10)||'jmsDestination.deliveryMode.Non-Persistent=2');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_priority','PRIORITY','"Priority"','java.lang.Integer','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.priority',2,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'jmsDestination.priority.default=-1'||chr(13)||chr(10)||'jmsDestination.priority.0=0'||chr(13)||chr(10)||'jmsDestination.priority.1=1'||chr(13)||chr(10)||'jmsDestination.priority.2=2'||chr(13)||chr(10)||'jmsDestination.priority.3=3'||chr(13)||chr(10)||'jmsDestination.priority.4=4'||chr(13)||chr(10)||'jmsDestination.priority.5=5'||chr(13)||chr(10)||'jmsDestination.priority.6=6'||chr(13)||chr(10)||'jmsDestination.priority.7=7'||chr(13)||chr(10)||'jmsDestination.priority.8=8'||chr(13)||chr(10)||'jmsDestination.priority.9=9');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_connectionFactoryJndi','CONNECTION_FACTORY_JNDI','"ConnectionFactoryJndi"','java.lang.String','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.connectionFactoryJndi',255,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=255');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_connectionUser','CONNECTION_USER','"ConnectionUser"','java.lang.String','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.connectionUser',30,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_connectionPassword','CONNECTION_PASSWORD','"ConnectionPassword"','java.lang.String','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.connectionPassword',30,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_lookupProperties','LOOKUP_PROPERTIES','"LookupProperties"','java.util.Properties','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.lookupProperties',0,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=other');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_retryInterval','RETRY_INTERVAL','"RetryInterval"','java.lang.Integer','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.retryInterval',11,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=range'||chr(13)||chr(10)||'range.min=1'||chr(13)||chr(10)||'range.max=65535');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_maximumRetries','MAXIMUM_RETRIES','"MaximumRetries"','java.lang.Integer','com.gridnode.pdip.app.alert.model.JmsDestination','jmsDestination.maximumRetries',11,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=range'||chr(13)||chr(10)||'range.min=-1'||chr(13)||chr(10)||'range.max=65535');

--------- MessageProperty
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" ='com.gridnode.pdip.app.alert.model.MessageProperty';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_key','KEY','','java.lang.String','com.gridnode.pdip.app.alert.model.MessageProperty','messageProperty.key',50,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=50');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_type','TYPE','','java.lang.Integer','com.gridnode.pdip.app.alert.model.MessageProperty','messageProperty.type',1,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'message.property.Boolean=1'||chr(13)||chr(10)||'message.property.Byte=2'||chr(13)||chr(10)||'message.property.Double=3'||chr(13)||chr(10)||'message.property.Float=4'||chr(13)||chr(10)||'message.property.Int=5'||chr(13)||chr(10)||'message.property.Long=6'||chr(13)||chr(10)||'message.property.Short=7'||chr(13)||chr(10)||'message.property.String=8');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_value','VALUE','','java.lang.String','com.gridnode.pdip.app.alert.model.MessageProperty','messageProperty.value',255,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=255');

--------- JmsMessageRecord
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" ='com.gridnode.pdip.app.alert.model.JmsMessageRecord';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'candelete.enabled=true'||chr(13)||chr(10)||'candelete.disabled=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_jmsDestinationUid','JMS_DESTINATION_UID','"JmsDestUid"','java.lang.Long','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,1,1,1,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=foreign'||chr(13)||chr(10)||'foreign.key=jmsDestination.uid'||chr(13)||chr(10)||'foreign.display=jmsDestination.name'||chr(13)||chr(10)||'foreign.cached=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_alertTimestamp','ALERT_TIMESTAMP','"AlertTimestamp"','java.util.Date','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,0,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=datetime'||chr(13)||chr(10)||'datetime.time=true'||chr(13)||chr(10)||'datetime.date=true'||chr(13)||chr(10)||'datetime.adjustment=gts');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_msgData','MESSAGE_DATA','"MsgData"','com.gridnode.pdip.app.alert.jms.MessageData','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,0,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=text'||chr(13)||chr(10)||'text.length.max=999999');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_permanentFailed','PERMANENT_FAILED','"PermanentFailed"','java.lang.Boolean','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=text'||chr(13)||chr(10)||'text.length.max=9');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_alertTimeInLong','ALERT_TIME_IN_LONG','"AlertTimeInLong"','java.lang.Long','com.gridnode.pdip.app.alert.model.JmsMessageRecord','',0,0,1,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=text'||chr(13)||chr(10)||'2/5/2007text.length.max=9');

