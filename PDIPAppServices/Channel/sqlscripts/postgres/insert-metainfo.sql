SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;
SET search_path = appdb;

DELETE FROM "entitymetainfo" WHERE "EntityName" IN ('ChannelInfo','CommInfo','SecurityInfo','PackagingInfo','AS2PackagingInfoExtension','FlowControlInfo');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.app.channel.model.ChannelInfo','ChannelInfo','"channel_info"');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.app.channel.model.CommInfo','CommInfo','"comm_info"');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.app.channel.model.SecurityInfo','SecurityInfo','"security_profile"');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.app.channel.model.PackagingInfo','PackagingInfo','"packaging_profile"');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.app.channel.model.AS2PackagingInfoExtension','AS2PackagingInfoExtension','');
INSERT INTO "entitymetainfo" VALUES ('com.gridnode.pdip.app.channel.model.FlowControlInfo','FlowControlInfo','');

--------- ChannelInfo
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.ChannelInfo';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.version',0,0,0,0,0,'0',999,'displayable=false','');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_refId','REF_ID','"RefId"','java.lang.String','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.refId',30,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'displayable.create=false','type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_tptProtocolType','TPT_PROTOCOL_TYPE','"TptProtocolType"','java.lang.String','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.tptProtocolType',10,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true','type=enum'||chr(13)||chr(10)||'channelInfo.tptProtocolType.jms=JMS'||chr(13)||chr(10)||'channelInfo.tptProtocolType.http=HTTP'||chr(13)||chr(10)||'channelInfo.tptProtocolType.soap=SOAP-HTTP');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.description',80,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_tptCommInfo','TPT_COMM_INFO','"TptCommInfo"','com.gridnode.pdip.app.channel.model.CommInfo','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.tptCommInfoUid',0,0,1,1,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=foreign'||chr(13)||chr(10)||'foreign.key=commInfo.uid'||chr(13)||chr(10)||'foreign.display=commInfo.name'||chr(13)||chr(10)||'foreign.cached=true');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_packagingInfo','PACKAGING_PROFILE','"PackagingProfile"','com.gridnode.pdip.app.channel.model.PackagingInfo','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.packagingProfile',0,0,1,1,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=foreign'||chr(13)||chr(10)||'foreign.key=packagingInfo.uid'||chr(13)||chr(10)||'foreign.display=packagingInfo.name'||chr(13)||chr(10)||'foreign.cached=true');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_securityInfo','SECURITY_PROFILE','"SecurityProfile"','com.gridnode.pdip.app.channel.model.SecurityInfo','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.securityProfile',0,0,1,1,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true','type=foreign'||chr(13)||chr(10)||'foreign.key=securityInfo.uid'||chr(13)||chr(10)||'foreign.display=securityInfo.name'||chr(13)||chr(10)||'foreign.cached=true');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_flowControlInfo','FLOWCONTROL_PROFILE','"FlowControlProfile"','com.gridnode.pdip.app.channel.model.FlowControlInfo','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.flowControlProfile',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=embedded'||chr(13)||chr(10)||'embedded.type=flowControlInfo');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.uid',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.name',30,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10)||'editable.update=false'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isMaster','IS_MASTER','"isMaster"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.isMaster',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isPartner','IS_PARTNER','"isPartner"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.isPartner',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.canDelete',0,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isDisable','IS_DISABLE','"isDisable"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.isDisable',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_partnerCategory','PARTNER_CAT','"PartnerCategory"','java.lang.Short','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.partnerCategory',80,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'##application specific'||chr(13)||chr(10)||'generic.partnerCategory.others=0'||chr(13)||chr(10)||'generic.partnerCategory.gridtalk=1'||chr(13)||chr(10)||'channelInfo.tptProtocolType.upc=UPC');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_isRelay','IS_RELAY','"isRelay"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.ChannelInfo','channelInfo.isRelay',0,0,0,1,1,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));

--------- CommInfo
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.CommInfo';
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.uid',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_tptImplVersion','TPT_IMPL_VERSION','"TptImplVersion"','java.lang.String','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.tptImplVersion',6,0,0,1,0,'0',999,'displayable=false','type=text'||chr(13)||chr(10)||'text.length.max=6');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_refId','REF_ID','"RefId"','java.lang.String','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.refId',30,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'displayable.create=false','type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.version',0,0,0,0,1,'0',999,'displayable=false','type=text');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_protocolType','PROTOCOL_TYPE','"ProtocolType"','java.lang.String','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.protocolType',10,0,1,1,1,'0',999,'editable=true'||chr(13)||chr(10)||'displayable=true'||chr(13)||chr(10)||'mandatory=true','type=enum'||chr(13)||chr(10)||'commInfo.protocolType.jms=JMS'||chr(13)||chr(10)||'commInfo.protocolType.http=HTTP'||chr(13)||chr(10)||'commInfo.protocolType.soap=SOAP-HTTP'||chr(13)||chr(10)||'commInfo.protocolType.upc=UPC');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.name',30,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10)||'editable.update=false'||chr(13)||chr(10)||'mandatory=true','type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.description',80,0,0,1,1,'',999,'displayable=true','type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isDefaultTpt','IS_DEFAULT_TPT','"IsDefaultTpt"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.defaultTpt',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'editable=false','type=enum'||chr(13)||chr(10)||'commInfo.defaultTpt.true=true'||chr(13)||chr(10)||'commInfo.defaultTpt.false=false');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.canDelete',0,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_partnerCategory','PARTNER_CAT','"PartnerCategory"','java.lang.Short','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.partnerCategory',80,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'##application specific'||chr(13)||chr(10)||'generic.partnerCategory.others=0'||chr(13)||chr(10)||'generic.partnerCategory.gridtalk=1');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isDisable','IS_DISABLE','"isDisable"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.isDisable',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isPartner','IS_PARTNER','"isPartner"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.isPartner',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_url','URL','"Url"','java.lang.String','com.gridnode.pdip.app.channel.model.CommInfo','commInfo.url',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=255');

--------- PackagingInfo
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.PackagingInfo';
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.uid',0,0,0,0,0,'0',999,'displayable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.name',30,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.description',80,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_envelope','ENVELOPE','"Envelope"','java.lang.String','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.envelope',10,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'packagingInfo.envelope.none=NONE'||chr(13)||chr(10)||'packagingInfo.envelope.rnif1=RNIF1'||chr(13)||chr(10)||'packagingInfo.envelope.rnif2=RNIF2'||chr(13)||chr(10)||'packagingInfo.envelope.as2=AS2'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.canDelete',0,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.version',0,0,0,1,1,'',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=range'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_refId','REF_ID','"RefId"','java.lang.String','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.refId',30,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_partnerCategory','PARTNER_CAT','"PartnerCategory"','java.lang.Short','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.partnerCategory',80,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'##application specific'||chr(13)||chr(10)||'generic.partnerCategory.others=0'||chr(13)||chr(10)||'generic.partnerCategory.gridtalk=1');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isDisable','IS_DISABLE','"isDisable"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.isDisable',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isPartner','IS_PARTNER','"isPartner"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.isPartner',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_pkgInfoExtension','PKG_INFO_EXTENSION','"PackagingInfoExtension"','com.gridnode.pdip.app.channel.model.PackagingInfoExtension','com.gridnode.pdip.app.channel.model.PackagingInfo','packagingInfo.packagingInfoExtension',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=dynamic'||chr(13)||chr(10)||'dynamic.types=as2PackagingInfoExtension'||chr(13)||chr(10));

--------- AS2PackagingInfoExtension.
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%AS2PackagingInfoExtension';
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isAckReq','IS_ACK_REQ','','java.lang.Boolean','com.gridnode.pdip.app.channel.model.AS2PackagingInfoExtension','as2PackagingInfoExtension.isAckReq',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isAckSigned','IS_ACK_SIGNED','','java.lang.Boolean','com.gridnode.pdip.app.channel.model.AS2PackagingInfoExtension','as2PackagingInfoExtension.isAckSigned',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isNRRReq','IS_NRR_REQ','','java.lang.Boolean','com.gridnode.pdip.app.channel.model.AS2PackagingInfoExtension','as2PackagingInfoExtension.isNrrReq',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isAckSyn','IS_ACK_SYN','','java.lang.Boolean','com.gridnode.pdip.app.channel.model.AS2PackagingInfoExtension','as2PackagingInfoExtension.isAckSyn',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_returnURL','RETURN_URL','','java.lang.String','com.gridnode.pdip.app.channel.model.AS2PackagingInfoExtension','as2PackagingInfoExtension.returnUrl',200,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=200');

--------- SecurityInfo
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.SecurityInfo';
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_description','DESCRIPTION','"Description"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.description',80,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=80');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_name','NAME','"Name"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.name',30,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_uId','UID','"UID"','java.lang.Long','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.uid',0,0,0,0,0,'0',999,'displayable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_encryptionLevel','ENCRYPTION_LEVEL','"EncryptionLevel"','java.lang.Integer','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.encLevel',0,0,0,0,0,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.encLevel.40=40'||chr(13)||chr(10)||'securityInfo.encLevel.64=64'||chr(13)||chr(10)||'securityInfo.encLevel.128=128'||chr(13)||chr(10)||'securityInfo.encLevel.168=168'||chr(13)||chr(10)||'securityInfo.encLevel.256=256'||chr(13)||chr(10)||'securityInfo.encLevel.512=512'||chr(13)||chr(10)||'securityInfo.encLevel.1024=1024');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_encryptionType','ENCRYPTION_TYPE','"EncryptionType"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.encType',10,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.encType.none=None'||chr(13)||chr(10)||'securityInfo.encType.asymmetric=Asymmetric'||chr(13)||chr(10)||'securityInfo.encType.smime=S/MIME');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_signatureEncryptionCertificateId','SIGNATURE_ENCRYPTION_CERTIFICATE_ID','"SignatureEncryptionCertificate"','java.lang.Long','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.sigEncCert',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=foreign'||chr(13)||chr(10)||'foreign.key=certificate.uid'||chr(13)||chr(10)||'foreign.display=certificate.name'||chr(13)||chr(10)||'foreign.cached=false'||chr(13)||chr(10)||'foreign.additionalDisplay=id');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_encryptionCertificateId','ENCRYPTION_CERTIFICATE_ID','"EncryptionCertificate"','java.lang.Long','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.encCert',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=foreign'||chr(13)||chr(10)||'foreign.key=certificate.uid'||chr(13)||chr(10)||'foreign.display=certificate.name'||chr(13)||chr(10)||'foreign.cached=false'||chr(13)||chr(10)||'foreign.additionalDisplay=id');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_signatureType','SIGNATURE_TYPE','"SignatureType"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.sigType',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.sigType.none=None'||chr(13)||chr(10)||'securityInfo.sigType.smime=S/MIME');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_digestAlgorithm','DIGEST_ALGORITHM','"DigestAlgorithm"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.digestAlgorithm',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.digestAlgorithm.md5=1.2.840.113549.2.5'||chr(13)||chr(10)||'securityInfo.digestAlgorithm.sha1=1.3.14.3.2.26');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_canDelete','CAN_DELETE','"CanDelete"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.canDelete',0,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_version','VERSION','"Version"','java.lang.Double','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.version',0,0,0,1,1,'',999,'displayable=false'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=range'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_refId','REF_ID','"RefId"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.refId',30,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=text'||chr(13)||chr(10)||'text.length.max=30');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_partnerCategory','PARTNER_CAT','"PartnerCategory"','java.lang.Short','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.partnerCategory',80,0,0,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'displayable.create=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'##application specific'||chr(13)||chr(10)||'generic.partnerCategory.others=0'||chr(13)||chr(10)||'generic.partnerCategory.gridtalk=1');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isDisable','IS_DISABLE','"isDisable"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.isDisable',0,0,0,0,0,'0',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isPartner','IS_PARTNER','"isPartner"','java.lang.Boolean','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.isPartner',0,0,0,0,0,'0',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_compressionType','COMPRESSION_TYPE','"CompressionType"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.compressionType',10,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.compressionType.none=None'||chr(13)||chr(10)||'securityInfo.compressionType.smime=S/MIME');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_compressionMethod','COMPRESSION_METHOD','"CompressionMethod"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.compressionMethod',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.compressionMethod.zlib=ZLIB');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_compressionLevel','COMPRESSION_LEVEL','"CompressionLevel"','java.lang.Integer','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.compressionLevel',0,0,0,0,0,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.compressionLevel.0=0'||chr(13)||chr(10)||'securityInfo.compressionLevel.1=1'||chr(13)||chr(10)||'securityInfo.compressionLevel.2=2'||chr(13)||chr(10)||'securityInfo.compressionLevel.3=3');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_sequence','SEQUENCE','"Sequence"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo','securityInfo.sequence',10,0,0,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.sequence.sign_compress=S;C'||chr(13)||chr(10)||'securityInfo.sequence.compress_sign=C;S'||chr(13)||chr(10)||'securityInfo.sequence.sign_encrypt=S;E'||chr(13)||chr(10)||'securityInfo.sequence.encrypt_sign=E;S'||chr(13)||chr(10)||'securityInfo.sequence.compress_encrypt=C;E'||chr(13)||chr(10)||'securityInfo.sequence.sign_compress_encrypt=S;C;E'||chr(13)||chr(10)||'securityInfo.sequence.compress_sign_encrypt=C;S;E'||chr(13)||chr(10)||'securityInfo.sequence.compress_encrypt_sign=C;E;S');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_encryptionAlgorithm','ENCRYPTION_ALGORITHM','"EncryptionAlgorithm"','java.lang.String','com.gridnode.pdip.app.channel.model.SecurityInfo', 'securityInfo.encryptionAlgorithm', 80,0,0,1,1,'', 999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'securityInfo.encryptionAlgorithm.TDES_ALG=1.2.840.113549.3.7'||chr(13)||chr(10)||'securityInfo.encryptionAlgorithm.RC2_ALG=1.2.840.113549.3.2');

--------- FlowControlInfo
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.FlowControlInfo';
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isZip','IS_ZIP','','java.lang.Boolean','com.gridnode.pdip.app.channel.model.FlowControlInfo','flowControlInfo.isZip',0,0,0,0,0,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_zipThreshold','ZIP_THRESHOLD','','java.lang.Integer','com.gridnode.pdip.app.channel.model.FlowControlInfo','flowControlInfo.zipThreshold',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=range');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_isSplit','IS_SPLIT','','java.lang.Boolean','com.gridnode.pdip.app.channel.model.FlowControlInfo','flowControlInfo.isSplit',0,0,0,0,0,'',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false'||chr(13)||chr(10));
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_splitThreshold','SPLIT_THRESHOLD','','java.lang.Integer','com.gridnode.pdip.app.channel.model.FlowControlInfo','flowControlInfo.splitThreshold',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=range');
INSERT INTO "fieldmetainfo" VALUES (DEFAULT,'_splitSize','SPLIT_SIZE','','java.lang.Integer','com.gridnode.pdip.app.channel.model.FlowControlInfo','flowControlInfo.splitSize',0,0,1,1,1,'0',999,'displayable=true'||chr(13)||chr(10)||'editable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10),'type=range');
