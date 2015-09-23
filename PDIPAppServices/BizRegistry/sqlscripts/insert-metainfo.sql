# Change Log
#
# 18 Aug 2003 GT 2.2 I1 [Neo Sok Lay] Add metainfo for RegistryObjectMapping entity.
# 03 Sep 2003 GT 2.2 I1 [Neo Sok Lay] Add metainfo for SearchRegistryCriteria, SearchRegistryQuery
# 24 Sep 2003 Gt 2.2 I1 [Neo Sok Lay] Add metainfo for RegistryConnectInfo entity.
# 23 Dec 2003 GT 2.3 I1 [Neo Sok Lay] Add metainfo for DomainIdentifier entity
# 19 Jan 2004 Gt 2.3 I1 [Daniel D'Cotta] Update WhitePage.Language constraint
# 22 Dec 2005 GT 4.0 I1 [Neo Sok Lay] Add Starfish Id domain identifier type

USE appdb;


#
# Dumping data FOR TABLE 'entitymetainfo'
#
INSERT INTO entitymetainfo VALUES("com.gridnode.pdip.app.bizreg.model.BusinessEntity","BusinessEntity","business_entity");
INSERT INTO entitymetainfo VALUES("com.gridnode.pdip.app.bizreg.model.WhitePage","WhitePage","whitepage");
INSERT INTO entitymetainfo VALUES("com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","RegistryObjectMapping","registry_object_map");
INSERT INTO entitymetainfo VALUES('com.gridnode.pdip.app.bizreg.search.model.SearchRegistryCriteria', 'SearchRegistryCriteria', '');
INSERT INTO entitymetainfo VALUES('com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'SearchRegistryQuery', '');
INSERT INTO entitymetainfo VALUES("com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","RegistryConnectInfo","registry_connect_info");
INSERT INTO entitymetainfo VALUES("com.gridnode.pdip.app.bizreg.model.DomainIdentifier","DomainIdentifier","domain_identifier");


#
# Dumping data FOR TABLE 'fieldmetainfo'
#

# BusinessEntity
INSERT INTO fieldmetainfo VALUES(NULL,"_uId","UID","UID","java.lang.Long","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.uid","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=uid\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_enterpriseId","ENTERPRISE_ID","EnterpriseID","java.lang.String","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.enterpriseId","0","0","0","1","1","","1","displayable=true\r\ndisplayable.create=false\r\neditable=false\r\nmandatory=false\r\n","## may change to foreign when Node management is ready\r\ntype=text\r\ntext.length.max=20\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_busEntId","ID","ID","java.lang.String","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.id","0","0","0","1","1","","2","displayable=true\r\neditable=false\r\neditable.create=true\r\nmandatory=true\r\n","type=text\r\ntext.length.max=4\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_desc","DESCRIPTION","Description","java.lang.String","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.description","0","0","0","1","1","","3","displayable=true\r\neditable=true\r\nmandatory=true\r\n","type=text\r\ntext.length.max=80\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_isPartner","IS_PARTNER","IsPartner","java.lang.Boolean","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.forPartner","0","0","0","1","1","","4","displayable=true\r\neditable=false\r\neditable.create=true\r\nmandatory=true\r\n\r\n","type=enum\r\ngeneric.yes=true\r\ngeneric.no=false\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_partnerCat","PARTNER_CATEGORY","PartnerCat","java.lang.Short","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.partnerCategory","0","0","0","1","1","","999","displayable=true\r\neditable=false\r\nmandatory=false\r\n","type=enum\r\n##application specific\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_isPublishable","IS_PUBLISHABLE","IsPublishable","java.lang.Boolean","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.publishable","0","0","0","1","1","","999","#temporary setting, kiv for uddi\r\ndisplayable=false\r\nmandatory=false\r\neditable=false\r\n","type=enum\r\ngeneric.yes=true\r\ngeneric.no=false\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_isSync","IS_SYNC_TO_SERVER","IsSyncToServer","java.lang.Boolean","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.syncToServer","0","0","0","1","1","","999","##temporary setting, kiv for uddi\r\ndisplayable=false\r\nmandatory=false\r\neditable=false\r\n","type=enum\r\ngeneric.yes=true\r\ngeneric.no=false\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_state","STATE","State","java.lang.Integer","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.beState","0","0","0","1","1","","5","displayable=true\r\neditable=false\r\nmandatory=false\r\n","type=enum\r\nbusinessEntity.beState.normal=0\r\nbusinessEntity.beState.deleted=1\r\n##will need more for application specific\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_canDelete","CAN_DELETE","CanDelete","java.lang.Boolean","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.canDelete","0","0","0","1","1","","999","displayable=true\r\neditable=false\r\nmandatory=false\r\n","type=enum\r\ngeneric.yes=true\r\ngeneric.no=false\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_version","VERSION","Version","java.lang.Double","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.version","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=range\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_whitePage","WHITE_PAGE","","com.gridnode.pdip.app.bizreg.model.WhitePage","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.whitePage","0","0","0","1","1","","999","","type=embedded\r\nembedded.type=whitePage\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_domainIdentifiers","DOMAIN_IDENTIFIERS","","java.util.Collection","com.gridnode.pdip.app.bizreg.model.BusinessEntity","businessEntity.domainIdentifiers","0","0","0","1","1","","999","","type=embedded\r\nembedded.type=domainIdentifier\r\ncollection=true\r\n");

# WhitePage
INSERT INTO fieldmetainfo VALUES(NULL,"_uId","UID","UID","java.lang.Long","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.uid","0","0","0","1","1","","999","displayable=false\r\nmandatory=false\r\neditable=false\r\n","type=uid\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_beUId","BE_UID","BizEntityUID","java.lang.Long","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.businessEntity","0","0","0","1","1","","999","displayable=true\r\neditable=false\r\nmandatory=false\r\n","type=foreign\r\nforeign.key=businessEntity.uid\r\nforeign.cached=false\r\nforeign.display=businessEntity.description\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_busDesc","BUSINESS_DESC","BusinessDesc","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.businessDesc","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=80\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_dUNS","DUNS","DUNS","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.duns","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\n## mandatory if BE is partner but not tied to any enterprise\r\nmandatory=false\r\n","type=text\r\ntext.length.max=20\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_globalSCCode","G_SUPPLY_CHAIN_CODE","GlobalSCCode","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.globalSupplyChainCode","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_contactPerson","CONTACT_PERSON","ContactPerson","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.contactPerson","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=80\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_email","EMAIL","Email","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.email","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_tel","TEL","Tel","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.tel","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=16\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_fax","FAX","Fax","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.fax","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=16\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_website","WEBSITE","Website","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.website","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_address","ADDRESS","Address","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.address","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_city","CITY","City","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.city","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=50\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_state","STATE","State","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.state","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","## may consider choose item from some State list\r\ntype=text\r\ntext.length.max=6\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_zipCode","ZIP_CODE","ZipCode","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.zipCode","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=10\r\n\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_pOBox","PO_BOX","POBox","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.poBox","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=10\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_country","COUNTRY","Country","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.country","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=foreign\r\nforeign.key=countryCode.alpha3Code\r\nforeign.display=countryCode.name\r\nforeign.cached=false\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_language","LANGUAGE","Language","java.lang.String","com.gridnode.pdip.app.bizreg.model.WhitePage","whitePage.language","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=foreign\r\nforeign.key=languageCode.alpha2Code\r\nforeign.display=languageCode.name\r\nforeign.cached=false\r\n");

# RegistryObjectMapping
INSERT INTO fieldmetainfo VALUES(NULL,"_uId","UID","UID","java.lang.Long","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.uid","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=uid\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_registryObjectKey","REGISTRY_OBJECT_KEY","RegistryObjectKey","java.lang.String","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.registryObjectKey","0","0","0","1","1","","1","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=text\r\ntext.length.max=50\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_registryObjectType","REGISTRY_OBJECT_TYPE","RegistryObjectType","java.lang.String","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.registryObjectType","0","0","0","1","1","","2","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=enum\r\nregistryObjectMapping.registryObjectType.organization=Organization\r\nregistryObjectMapping.registryObjectType.service=Service\r\nregistryObjectMapping.registryObjectType.binding=Binding\r\nregistryObjectMapping.registryObjectType.scheme=Scheme\r\nregistryObjectMapping.registryObjectType.concept=Concept\r\nregistryObjectMapping.registryObjectType.specification=Specification\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_registryQueryUrl","REGISTRY_QUERY_URL","RegistryQueryUrl","java.lang.String","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.registryQueryUrl","0","0","0","1","1","","3","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_registryPublishUrl","REGISTRY_PUBLISH_URL","RegistryPublishUrl","java.lang.String","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.registryPublishUrl","0","0","0","1","1","","4","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_proprietaryObjectType","PROPRIETARY_OBJECT_TYPE","ProprietaryObjectType","java.lang.String","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.proprietaryObjectType","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=text\r\ntext.length.max=30\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_proprietaryObjectKey","PROPRIETARY_OBJECT_KEY","ProprietaryObjectKey","java.lang.String","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.proprietaryObjectKey","0","0","0","1","1","","999","displayable=false\r\nmandatory=false\r\neditable=false\r\n","type=text\r\ntext.length.max=50\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_isPublishedObject","IS_PUBLISHED_OBJECT","IsPublishedObject","java.lang.Boolean","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.isPublishedObject","0","0","0","1","1","","999","displayable=false\r\nmandatory=false\r\neditable=false\r\n","type=enum\r\ngeneric.yes=true\r\ngeneric.no=false\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_state","STATE","State","java.lang.Short","com.gridnode.pdip.app.bizreg.pub.model.RegistryObjectMapping","registryObjectMapping.state","0","0","0","1","1","","5","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=enum\r\nregistryObjectMapping.state.sync=0\r\nregistryObjectMapping.state.deleted=1\r\nregistryObjectMapping.state.pendDelete=2\r\nregistryObjectMapping.state.pendUpdate=3\r\n");

# SearchRegistryCriteria
INSERT INTO fieldmetainfo VALUES(NULL,"_match","MATCH","","java.lang.Short","com.gridnode.pdip.app.bizreg.search.model.SearchRegistryCriteria","searchRegistryCriteria.match","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=true\r\neditable.display=false\r\n","type=enum\r\searchRegistryCriteria.match.all=1\r\nsearchRegistryCriteria.match.any=2\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_busEntityDesc","BUS_ENTITY_DESC","","java.lang.String","com.gridnode.pdip.app.bizreg.search.model.SearchRegistryCriteria","searchRegistryCriteria.busEntityDesc","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\neditable.display=false\r\n","type=text\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_messagingStandards","MESSAGING_STANDARDS","","java.util.Collection","com.gridnode.pdip.app.bizreg.search.model.SearchRegistryCriteria","searchRegistryCriteria.messagingStandards","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=true\r\neditable.display=false\r\n","collection=true\r\ntype=text\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_queryUrl","QUERY_URL","","java.lang.String","com.gridnode.pdip.app.bizreg.search.model.SearchRegistryCriteria","searchRegistryCriteria.queryUrl","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=true\r\neditable.display=false\r\n","type=text\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_duns","DUNS","","java.lang.String","com.gridnode.pdip.app.bizreg.search.model.SearchRegistryCriteria","searchRegistryCriteria.duns","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=false\r\neditable.display=false\r\n","type=text\r\n");

# SearchRegistryQuery
INSERT INTO fieldmetainfo VALUES(NULL, '_searchID', 'SEARCH_ID', '', 'java.lang.Long', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'searchRegistryQuery.searchId', 0, 0, 0, 1, 1, NULL, 999, 'displayable=true\r\neditable=false\r\nmandatory=false\r\n', 'type=uid\r\n');
INSERT INTO fieldmetainfo VALUES(NULL, '_dtSubmitted', 'DT_SUBMITTED', '', 'java.sql.Timestamp', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'searchRegistryQuery.dtSubmitted', 0, 0, 0, 1, 1, NULL, 999, 'displayable=true\r\neditable=false\r\nmandatory=false\r\n', 'type=datetime\r\ndatetime.date=true\r\ndatetime.time=true\r\n');
INSERT INTO fieldmetainfo VALUES(NULL, '_dtResponded', 'DT_RESPONDED', '', 'java.sql.Timestamp', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'searchRegistryQuery.dtResponded', 0, 0, 0, 1, 1, NULL, 999, 'displayable=true\r\neditable=false\r\nmandatory=false\r\n', 'type=datetime\r\ndatetime.date=true\r\ndatetime.time=true\r\n');
INSERT INTO fieldmetainfo VALUES(NULL, '_criteria', 'CRITERIA', '', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryCriteria', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'searchRegistryQuery.criteria', 0, 0, 0, 1, 1, NULL, 999, 'displayable=true\r\neditable=false\r\nmandatory=false\r\n', 'type=embedded\r\nembedded.type=searchRegistryCriteria');
INSERT INTO fieldmetainfo VALUES(NULL, '_results', 'RESULTS', '', 'java.util.Collection', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'searchRegistryQuery.results', 0, 0, 0, 1, 1, NULL, 999, 'displayable=true\r\neditable=false\r\nmandatory=false\r\n', 'collection=true\r\ntype=embedded\r\nembedded.type=searchedBusinessEntity\r\n');
INSERT INTO fieldmetainfo VALUES(NULL, '_rawResults', 'RAW_RESULTS', '', 'java.util.Collection', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', '', 0, 0, 0, 1, 1, NULL, 999, 'displayable=false\r\neditable=false\r\nmandatory=false\r\n', '');
INSERT INTO fieldmetainfo VALUES(NULL, '_isException', 'IS_EXCEPTION', '', 'java.lang.Boolean', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'searchRegistryQuery.isException', 0, 0, 0, 1, 1, NULL, 999, 'displayable=true\r\neditable=false\r\nmandatory=false\r\n', 'type=enum\r\ngeneric.yes=true\r\ngeneric.no=false');
INSERT INTO fieldmetainfo VALUES(NULL, '_exceptionStr', 'EXCEPTION_STR', '', 'java.lang.String', 'com.gridnode.pdip.app.bizreg.search.model.SearchRegistryQuery', 'searchRegistryQuery.exceptionStr', 0, 0, 0, 1, 1, NULL, 999, 'displayable=true\r\neditable=false\r\nmandatory=false\r\n', 'type=text\r\n');

# RegistryConnectInfo
INSERT INTO fieldmetainfo VALUES(NULL,"_uId","UID","UID","java.lang.Long","com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","registryConnectInfo.uid","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=uid\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_name","NAME","Name","java.lang.String","com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","registryConnectInfo.name","0","0","0","1","1","","1","displayable=true\r\neditable=false\r\neditable.create=true\r\nmandatory=true\r\n","type=text\r\ntext.length.max=50\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_queryUrl","QUERY_URL","QueryUrl","java.lang.String","com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","registryConnectInfo.queryUrl","0","0","0","1","1","","3","displayable=true\r\neditable=true\r\nmandatory=true\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_publishUrl","PUBLISH_URL","PublishUrl","java.lang.String","com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","registryConnectInfo.publishUrl","0","0","0","1","1","","4","displayable=true\r\neditable=true\r\nmandatory=false\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_publishPassword","PUBLISH_PASSWORD","PublishPassword","java.lang.String","com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","registryConnectInfo.publishPassword","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=true\r\n","type=text\r\ntext.length.max=20\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_publishUser","PUBLISH_USER","PublishUser","java.lang.String","com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","registryConnectInfo.publishUser","0","0","0","1","1","","999","displayable=true\r\nmandatory=true\r\neditable=true\r\n","type=text\r\ntext.length.max=20\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_canDelete","CAN_DELETE","CanDelete","java.lang.Boolean","com.gridnode.pdip.app.bizreg.model.RegistryConnectInfo","registryConnectInfo.canDelete","0","0","0","1","1","","999","displayable=true\r\neditable=false\r\nmandatory=false\r\n","type=enum\r\ngeneric.yes=true\r\ngeneric.no=false\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_version","VERSION","Version","java.lang.Double","com.gridnode.pdip.pdip.app.model.RegistryConnectInfo","registryConnectInfo.version","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n","type=range\r\n");

# DomainIdentifier
INSERT INTO fieldmetainfo VALUES(NULL,"_uId","UID","UID","java.lang.Long","com.gridnode.pdip.app.bizreg.model.DomainIdentifier","domainIdentifier.uid","0","0","0","1","1","","999","displayable=false\r\nmandatory=false\r\neditable=false\r\n","type=uid\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_beUid","BUSINESS_ENTITY_UID","BizEntityUID","java.lang.Long","com.gridnode.pdip.app.bizreg.model.DomainIdentifier","domainIdentifier.beUid","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n",NULL);
INSERT INTO fieldmetainfo VALUES(NULL,"_domainName","DOMAIN_NAME","Domain","java.lang.String","com.gridnode.pdip.app.bizreg.model.DomainIdentifier","domainIdentifier.domainName","0","0","0","1","1","","999","displayable=false\r\neditable=false\r\nmandatory=false\r\n",NULL);
INSERT INTO fieldmetainfo VALUES(NULL,"_type","TYPE","Type","java.lang.String","com.gridnode.pdip.app.bizreg.model.DomainIdentifier","domainIdentifier.type","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=true\r\n","type=enum\r\ndomainIdentifier.type.duns=DunsNumber\r\ndomainIdentifier.type.as2id=As2Identifier\r\ndomainIdentifier.type.discoveryUrl=DiscoveryUrl\r\ndomainIdentifier.type.gln=GlobalLocationNumber\r\ndomainIdentifier.type.starfishId=StarfishId\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_value","VALUE","Value","java.lang.String","com.gridnode.pdip.app.bizreg.model.DomainIdentifier","domainIdentifier.value","0","0","0","1","1","","999","displayable=true\r\neditable=true\r\nmandatory=true\r\n","type=text\r\ntext.length.max=255\r\n");
INSERT INTO fieldmetainfo VALUES(NULL,"_canDelete","CAN_DELETE","CanDelete","java.lang.Boolean","com.gridnode.pdip.app.bizreg.model.DomainIdentifier","domainIdentifier.canDelete","0","0","0","1","1","","999","displayable=true\r\neditable=false\r\nmandatory=false\r\n","type=enum\r\ngeneric.yes=true\r\ngeneric.no=false\r\n");
