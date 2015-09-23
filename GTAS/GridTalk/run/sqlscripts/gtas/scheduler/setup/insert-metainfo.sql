SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;
SET search_path = appdb;

DELETE FROM "entitymetainfo" WHERE "EntityName" = 'Schedule';
INSERT INTO "entitymetainfo" VALUES('com.gridnode.gtas.server.scheduler.model.Schedule','Schedule','');


---
--- data for table '"fieldmetainfo"'
---
--------- Schedule
DELETE FROM "fieldmetainfo" WHERE "EntityObjectName" LIKE '%.Schedule';
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_uId','UID','','java.lang.Long','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.uid',0,0,0,0,0,'',999,'displayable=false'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=false','type=uid');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_taskType','TASK_TYPE','','java.lang.String','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.taskType',100,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=false'||chr(13)||chr(10)||'editable.create=true','type=enum'||chr(13)||chr(10)||'scheduledTask.taskType.userProcedure=UserProcedure'||chr(13)||chr(10)||'scheduledTask.taskType.checkLicense=CheckLicense'||chr(13)||chr(10)||'scheduledTask.taskType.housekeepingInfo=HousekeepingInfo'||chr(13)||chr(10)||'scheduledTask.taskType.dbArchive=DBArchive');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_taskId','TASK_ID','','java.lang.String','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.taskId',120,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=120');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_disabled','DISABLED','','java.lang.Boolean','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.isDisabled',0,0,0,0,0,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'generic.yes=true'||chr(13)||chr(10)||'generic.no=false');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_startDate','START_DATE','','java.util.Date','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.startDate',0,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=datetime'||chr(13)||chr(10)||'datetime.time=false'||chr(13)||chr(10)||'datetime.date=true'||chr(13)||chr(10)||'datetime.pattern=yyyy-MM-dd');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_startTime','START_TIME','','java.lang.String','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.runTime',5,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=text'||chr(13)||chr(10)||'text.length.max=5');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_timesToRun','TIMES_TO_RUN','','java.lang.Integer','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.count',0,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=false'||chr(13)||chr(10)||'editable=true','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_delayPeriod','DELAY_PERIOD','','java.lang.Integer','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.interval',0,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=range');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_frequency','FREQUENCY','','java.lang.Integer','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.frequency',0,0,1,1,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'scheduledTask.frequency.once=-1'||chr(13)||chr(10)||'scheduledTask.frequency.minutely=2'||chr(13)||chr(10)||'scheduledTask.frequency.hourly=3'||chr(13)||chr(10)||'scheduledTask.frequency.daily=4'||chr(13)||chr(10)||'scheduledTask.frequency.weekly=5'||chr(13)||chr(10)||'scheduledTask.frequency.monthly=6');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_daysOfWeek','DAYS_OF_WEEK','','java.util.ArrayList','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.daysOfWeek',0,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'collection=true'||chr(13)||chr(10)||'collection.element=java.lang.Integer'||chr(13)||chr(10)||'scheduledTask.daysOfWeek.monday=0'||chr(13)||chr(10)||'scheduledTask.daysOfWeek.tuesday=1'||chr(13)||chr(10)||'scheduledTask.daysOfWeek.wednesday=2'||chr(13)||chr(10)||'scheduledTask.daysOfWeek.thursday=3'||chr(13)||chr(10)||'scheduledTask.daysOfWeek.friday=4'||chr(13)||chr(10)||'scheduledTask.daysOfWeek.saturday=5'||chr(13)||chr(10)||'scheduledTask.daysOfWeek.sunday=6');
INSERT INTO "fieldmetainfo" VALUES(DEFAULT,'_weekOfMonth','WEEK_OF_MONTH','','java.lang.Integer','com.gridnode.gtas.server.scheduler.model.Schedule','scheduledTask.weekOfMonth',0,0,1,0,1,'',999,'displayable=true'||chr(13)||chr(10)||'mandatory=true'||chr(13)||chr(10)||'editable=true','type=enum'||chr(13)||chr(10)||'scheduledTask.weekOfMonth.first=1'||chr(13)||chr(10)||'scheduledTask.weekOfMonth.second=2'||chr(13)||chr(10)||'scheduledTask.weekOfMonth.third=3'||chr(13)||chr(10)||'scheduledTask.weekOfMonth.fourth=4'||chr(13)||chr(10)||'scheduledTask.weekOfMonth.last=-1');
