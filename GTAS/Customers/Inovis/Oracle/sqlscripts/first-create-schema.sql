-- -----------------------------------------------------------------------------------
-- This script creates the Schemas for GridTalk and The Transaction Monitoring Module
-- 
-- Required user to connect as SYSDBA to grant the necessary privileges
-- -----------------------------------------------------------------------------------


-- --------------------------
-- Creates the Users 'APPDB' 
-- --------------------------

--
-- Definition for USER APPDB:
--
CREATE USER APPDB
  IDENTIFIED BY "gridnode"
    DEFAULT TABLESPACE GRIDTALK_DATA01
    TEMPORARY TABLESPACE TEMP
    PROFILE "DEFAULT"
    ACCOUNT UNLOCK  QUOTA UNLIMITED ON GRIDTALK_DATA01;
--
-- Grants for USER APPDB
--
-- System Privileges 
GRANT CREATE DATABASE LINK TO APPDB;
GRANT CREATE PROCEDURE TO APPDB;
GRANT CREATE SEQUENCE TO APPDB;
GRANT CREATE SYNONYM TO APPDB;
GRANT CREATE VIEW TO APPDB;
GRANT CREATE ROLE TO APPDB;
GRANT CREATE TYPE TO APPDB;
GRANT CREATE MATERIALIZED VIEW TO APPDB;
GRANT CREATE TRIGGER TO APPDB;
GRANT CREATE PUBLIC SYNONYM TO APPDB;
GRANT ALTER SESSION TO APPDB;
GRANT CREATE SESSION TO APPDB;
GRANT CREATE TABLE TO APPDB;

--- Roles
GRANT "CONNECT" TO APPDB;

--- Object Privileges
GRANT EXECUTE ON SYS.DBMS_STATS TO APPDB;
/


-- ------------------------------
-- Creates the Users 'ARCHIVEDB' 
-- ------------------------------

--
-- Definition for USER ARCHIVEDB:
--
CREATE USER ARCHIVEDB
  IDENTIFIED BY "gridnode"
    DEFAULT TABLESPACE GRIDTALK_DATA01
    TEMPORARY TABLESPACE TEMP
    PROFILE "DEFAULT"
    ACCOUNT UNLOCK  QUOTA UNLIMITED ON GRIDTALK_DATA01;

--
-- Grants for USER ARCHIVEDB
--
-- System Privileges 
GRANT CREATE SESSION TO ARCHIVEDB;
GRANT CREATE TYPE TO ARCHIVEDB;
GRANT CREATE SYNONYM TO ARCHIVEDB;
GRANT CREATE PUBLIC SYNONYM TO ARCHIVEDB;
GRANT CREATE TABLE TO ARCHIVEDB;
GRANT CREATE MATERIALIZED VIEW TO ARCHIVEDB;
GRANT CREATE TRIGGER TO ARCHIVEDB;
GRANT CREATE DATABASE LINK TO ARCHIVEDB;
GRANT CREATE SEQUENCE TO ARCHIVEDB;
GRANT CREATE PROCEDURE TO ARCHIVEDB;
GRANT ALTER SESSION TO ARCHIVEDB;
GRANT CREATE ROLE TO ARCHIVEDB;
GRANT CREATE VIEW TO ARCHIVEDB;

-- Roles
GRANT "CONNECT" TO ARCHIVEDB;

-- Object Privileges
GRANT EXECUTE ON SYS.DBMS_STATS TO ARCHIVEDB;
/


-- ---------------------------
-- Creates the Users 'USERDB' 
-- ---------------------------

--
-- Definition for USER USERDB:
--
CREATE USER USERDB
  IDENTIFIED BY "gridnode"
    DEFAULT TABLESPACE GRIDTALK_DATA01
    TEMPORARY TABLESPACE TEMP
    PROFILE "DEFAULT"
    ACCOUNT UNLOCK  QUOTA UNLIMITED ON GRIDTALK_DATA01;
--
-- Grants for USER USERDB
--
-- System Privileges
GRANT CREATE DATABASE LINK TO USERDB;
GRANT ALTER SESSION TO USERDB;
GRANT CREATE PUBLIC SYNONYM TO USERDB;
GRANT CREATE TABLE TO USERDB;
GRANT CREATE PROCEDURE TO USERDB;
GRANT CREATE TYPE TO USERDB;
GRANT CREATE SEQUENCE TO USERDB;
GRANT CREATE SESSION TO USERDB;
GRANT CREATE TRIGGER TO USERDB;
GRANT CREATE SYNONYM TO USERDB;
GRANT CREATE MATERIALIZED VIEW TO USERDB;
GRANT CREATE ROLE TO USERDB;
GRANT CREATE VIEW TO USERDB;

-- Roles
GRANT "CONNECT" TO USERDB;

-- Object Privileges
GRANT EXECUTE ON SYS.DBMS_STATS TO USERDB;
/


-- -------------------------------------------------------------
-- Creates the Users 'GTVAN' for Transaction Monitoring Module 
-- -------------------------------------------------------------

--
-- Definition for USER GTVAN
--
CREATE USER GTVAN
  IDENTIFIED BY "gridnode"
    DEFAULT TABLESPACE GRIDTALK_DATA01
    TEMPORARY TABLESPACE TEMP
    PROFILE "DEFAULT"
    ACCOUNT UNLOCK  QUOTA UNLIMITED ON GRIDTALK_DATA01;
--
-- Grants for USER APPDB
--
-- System Privileges 
GRANT CREATE DATABASE LINK TO GTVAN;
GRANT CREATE PROCEDURE TO GTVAN;
GRANT CREATE SEQUENCE TO GTVAN;
GRANT CREATE SYNONYM TO GTVAN;
GRANT CREATE VIEW TO GTVAN;
GRANT CREATE ROLE TO GTVAN;
GRANT CREATE TYPE TO GTVAN;
GRANT CREATE MATERIALIZED VIEW TO GTVAN;
GRANT CREATE TRIGGER TO GTVAN;
GRANT CREATE PUBLIC SYNONYM TO GTVAN;
GRANT ALTER SESSION TO GTVAN;
GRANT CREATE SESSION TO GTVAN;
GRANT CREATE TABLE TO GTVAN;

--- Roles
GRANT "CONNECT" TO GTVAN;

--- Object Privileges
GRANT EXECUTE ON SYS.DBMS_STATS TO GTVAN;
/