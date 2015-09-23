-- Table: purchase_order

-- DROP TABLE purchase_order;

CREATE TABLE purchase_order
(
  thisdocumentid character varying(255),
  thisdocgenerationdatetime character varying(255),
  from_gbusinessid character varying(255),
  status_code character varying(255),
  sys_date character varying(255),
  torole_gpartnerclasscode character varying(255),
  torole_gsupplychaincode character varying(255),
  torole_gbusinessid character varying(255),
  totalamt_monetaryamt character varying(255),
  totalamt_currcode character varying(255),
  shipto_regionname character varying(255),
  shipto_postoffbox character varying(255),
  shipto_postalcode character varying(255),
  shipto_glocationid character varying(255),
  shipto_gpartnerclasscode character varying(255),
  shipto_gbusinessid character varying(255),
  shipto_addressline1 character varying(255),
  shipping_gfobcode character varying(255),
  shipping_gshipmenttermcode character varying(255),
  requested_quantity character varying(255),
  shipping_accountid character varying(255),
  shipping_gcarriercode character varying(255),
  shipping_servicelevelcode character varying(255),
  shipping_spechandlingtext character varying(255),
  requested_datetimestamp character varying(255),
  requested_gtransporteventcode character varying(255),
  shipto_businessname character varying(255),
  shipto_addressline2 character varying(255),
  shipto_addressline3 character varying(255),
  shipto_cityname character varying(255),
  shipto_countrycode character varying(255),
  acc_bill_globalpartnerclasscode character varying(255),
  uom character varying(255),
  finterm_fintermcode character varying(255),
  from_gsuppchaincode character varying(255),
  from_gpartnerclasscode character varying(255),
  globaldocfunccode character varying(255),
  po_accountname character varying(255),
  po_accountnumber character varying(255),
  acc_bill_businessname character varying(255),
  acc_bill_businessid character varying(255),
  acc_bill_globlocationid character varying(255),
  acc_bill_adressline1 character varying(255),
  acc_bill_adressline2 character varying(255),
  acc_bill_adressline3 character varying(255),
  acc_bill_cityname character varying(255),
  acc_bill_countrycode character varying(255),
  acc_bill_nationalpostalcode character varying(255),
  acc_bill_postoffbox character varying(255),
  acc_bill_regionname character varying(255),
  acc_bill_telnumber character varying(255),
  from_contactname character varying(255),
  from_emailaddress character varying(255),
  from_telnumber character varying(255),
  from_gpartnerroleclasscode character varying(255),
  finterm_percentdue character varying(255),
  globalpotypecode character varying(255),
  torole_gpartnerroleclasscode character varying(255),
  finterm_nettermsdays character varying(255),
  finterm_paymentconditioncode character varying(255),
  finterm_discountsday character varying(255),
  contractid character varying(255),
  comments character varying(255),
  isdropship character varying(255)
) 
WITHOUT OIDS;
ALTER TABLE purchase_order OWNER TO postgres;




