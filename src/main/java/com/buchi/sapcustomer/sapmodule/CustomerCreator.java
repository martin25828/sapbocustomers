package com.buchi.sapcustomer.sapmodule;


import com.buchi.sapcustomer.web.model.CustomerDto;
import com.sap.smb.sbo.api.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Calendar;


@Slf4j
@Getter
public class CustomerCreator
{

    public ICompany company;
    private int connectionResult = -1;
    String errorMessage;
    Integer errorCode;




    public String createBusinessPartner(String companyCode, CustomerDto customerDto) throws SBOCOMException, IOException {



        connectionResult = connect(companyCode);

        if(connectionResult==0)

        {
            String compId = "SELECT U_COR_BU_ID FROM OADM";
            IRecordset recordSetCompNumber = SBOCOMUtil.newRecordset(company);
            recordSetCompNumber.doQuery(compId);
            recordSetCompNumber.moveFirst();
            int companyId = recordSetCompNumber.getFields().item(0).getValueInteger();




            // String sqlCardCodeMax = "SELECT MAX(CardCode)+1" +

            String sqlCardCodeMax = "SELECT MAX(CardCode) + 1" +
                    "FROM OCRD WHERE LEN(CardCode) = 9" +
                    "AND LEFT(CardCode, 2) = '" + String.valueOf(companyId) + "'" +
                    "AND SUBSTRING(CardCode,3,1) = 1";

            IRecordset recordSetCardCode =  SBOCOMUtil.newRecordset(company);
            recordSetCardCode.doQuery(sqlCardCodeMax);
            recordSetCardCode.moveFirst();

            int nextCardCode = recordSetCardCode.getFields().item(0).getValueInteger();


            //IBusinessPartners businessPartner = SBOCOMUtil.getBusinessPartners(company, "341003800");

            IBusinessPartners businessPartner = SBOCOMUtil.newBusinessPartners(company);
            businessPartner.setCardCode(String.valueOf(nextCardCode));
            businessPartner.setCardName(customerDto.getCardName());
           // businessPartner.setGroupCode(Integer.valueOf(customerDto.getGroupCode()));
            businessPartner.setCurrency(customerDto.getCurrency());
            businessPartner.setPhone1(customerDto.getPhone1());
            businessPartner.setWebsite(customerDto.getWebside());
            //businessPartner.setIndustry(Integer.valueOf(customerDto.getIndustry()));
            businessPartner.setValid(0);
            if(customerDto.getPaymentTerms() != null)
            {
                businessPartner.setPayTermsGrpCode(Integer.valueOf(customerDto.getPaymentTerms()));
            }
            //businessPartner.setSalesPersonCode(Integer.valueOf(customerDto.getSalesEmployee()));
            //businessPar


            IUserFields businessPartnerUDF = businessPartner.getUserFields();
            IFields businessPartnerField = businessPartnerUDF.getFields();

            businessPartnerField.item("U_COR_BU_Incoterms").setValue(customerDto.getIncoterms());
            //salesOrder.update();


            IBPAddresses ibpAddresses = businessPartner.getAddresses();
            //ibpAddresses.setCurrentLine(2);


            //ibpAddresses.


            /*
            ibpAddresses.setAddressName("Bill To Address");
            ibpAddresses.setAddressType(0);
            ibpAddresses.setCountry(customerDto.getBillToCountry());
            ibpAddresses.setBuildingFloorRoom(customerDto.getBillToBuilding());
            ibpAddresses.setCounty(customerDto.getBillToCountry());
            ibpAddresses.setCountry(customerDto.getBillToCountry());
            ibpAddresses.setZipCode(customerDto.getBillToPostCode());

            ibpAddresses.add(); */

            //System.out.println(ibpAddresses.getAddressName());

            //ibpAddresses.get

            businessPartner.setAddress(customerDto.getBillToAddress());
            businessPartner.setBillToBuildingFloorRoom(customerDto.getBillToBuilding());
            //businessPartner.setBillToState(customerDto.getBillToState());
            businessPartner.setCountry(customerDto.getBillToCountry());
            businessPartner.setCounty(customerDto.getBillToCounty());
            businessPartner.setZipCode(customerDto.getBillToPostCode());


            businessPartner.setMailAddress(customerDto.getShipToAddress());
            businessPartner.setShipToBuildingFloorRoom(customerDto.getShipToBuilding());
            businessPartner.setMailCity(customerDto.getShipToCity());
            businessPartner.setMailCountry(customerDto.getShipToCountry());
            businessPartner.setMailCounty(customerDto.getShipToCounty());
            businessPartner.setMailZipCode(customerDto.getShipToPostCode());






            if (businessPartner.add() == 0)
            {

                this.errorCode = 200;
                this.errorMessage = "Business Partner" +  customerDto.getCardName() +"was created sucesscessfully!";

                SBOErrorMessage errMsg = company.getLastError();

                //this.errorCode = errMsg.getErrorCode();
                //this.errorMessage = "Error Message:"+ errMsg.getErrorMessage();
                //System.out.println(this.errorMessage);


            }
            else
            {
                // get error message fom SAP Business One Server
                SBOErrorMessage errMsg = company.getLastError();

                this.errorCode = errMsg.getErrorCode();
                this.errorMessage = "Error Message:"+ errMsg.getErrorMessage();
                System.out.println(this.errorMessage);

            }

        }


        if(connectionResult==0)
        {
            disconnect();
        }

        return this.errorMessage;

        // Set Default Ship to Address

     /*   private String billToAddressId;
        private String billToAddress2;
        private String billToAddress3;
        private String billToStreet;
        private String billToStreetNumber;
        private String billToBuilding;
        private String billToPostCode;
        private String billToCity;
        private String billToState;
        private String billToCounty;
        private String billToCountry;*/

       




        //Set Default Bill To Address


        /*

        private String cardName;
    private String groupName;
    private String currency;
    private String phone1;
    private String webside;
    private String incoterms;
    private String industry;
    private String salesEmployee;
    private String status;
    private String paymentTermns;

    // BillTo Address
    private String billToAddressId;
    private String billToAddress2;
    private String billToAddress3;
    private String billToStreet;
    private String billToStreetNumber;
    private String billToBuilding;
    private String billToPostCode;
    private String billToCity;
    private String billToState;
    private String billToCounty;
    private String billToCountry;

    //U_COR_BU_CRMGUID
    private String billToGlobalIdentificationCode;
    //U_COR_BU_CompName
    private String billToCompanyName;



    // ShipTo Address
    private String shipToAddressId;
    private String shipToAddress2;
    private String shipToAddress3;
    private String shipToStreet;
    private String shipToStreetNumber;
    private String shipToBuilding;
    private String shipToPostCode;
    private String shipToCity;
    private String shipToState;
    private String shipToCounty;
    private String shipToCountry;
    private String shipToGlobalIdentificationCode;
    private String shipToCompanyName;


        */


    }

    public int connect(String companyCode) throws IOException
    {
        try
        {
            //File fs4 = new File("C:\\Users\\admin_creh\\Desktop\\testimport4.csv");
            // fs4.createNewFile();

            // initialise company instance
            company = SBOCOMUtil.newCompany();

            // File fs8 = new File("C:\\Users\\admin_creh\\Desktop\\testimport8.csv");
            //fs8.createNewFile();
            // set database server host

            String server="";
            String pw = "";


            switch(companyCode)
            {
                case "BCN":
                    server="bltchsap003";
                    pw ="yiOeR6KBY$k";
                    break;
                case "BUS":
                    server="bltchsap003";
                    pw ="yiOeR6KBY$k";
                    break;
                case "BHK":
                    server="bltchsap003";
                    pw ="yiOeR6KBY$k";
                    break;
                case "BUK":
                    server="bltchsap003";
                    pw ="yiOeR6KBY$k";
                    break;
                case "BFR":
                    server="bltchsap003";
                    pw ="yiOeR6KBY$k";
                    break;
                case "BIT":
                    server="bltchsap003";
                    pw ="yiOeR6KBY$k";
                    break;
                case "BTH":
                    server="bltchsap004";
                    pw ="kwo8$THTfwL";
                    break;
                case "BKR":
                    server="bltchsap004";
                    pw ="kwo8$THTfwL";
                    break;
                case "BDE":
                    server="bltchsap004";
                    pw ="kwo8$THTfwL";
                    break;
                case "BMY":
                    server="bltchsap004";
                    pw ="kwo8$THTfwL";
                    break;
                case "BSG":
                    server="bltchsap004";
                    pw ="kwo8$THTfwL";
                    break;
                case "BJP":
                    server="bltchsap004";
                    pw ="kwo8$THTfwL";
                    break;
                case "BID":
                    server="bltchsap004";
                    pw ="kwo8$THTfwL";
                    break;
                case "BBR":
                    server="bltchsap006";
                    pw ="j$he4GvP9x2A";
                    break;
                default:
                    server="bltchsap003";
                    break;

            }



            company.setServer(server);
            // set company database
            company.setCompanyDB("SAP_Buchi_"+companyCode+"_TEST");
            // set SAP user
            company.setUserName("import");
            // set SAP user password
            company.setPassword("BuchiBulk");
            // set SQL server version
            company.setDbServerType(SBOCOMConstants.BoDataServerTypes_dst_MSSQL2012);
            // set whether to use trusted connection to SQL server
            company.setUseTrusted(false);
            // set SAP Business One language
            company.setLanguage(SBOCOMConstants.BoSuppLangs_ln_English);
            // set database user
            company.setDbUserName("sa");
            // set database user password
            company.setDbPassword(pw);
            // set license server and port
            company.setLicenseServer("bltchsap002:30000");



            // File fs7 = new File("C:\\Users\\admin_creh\\Desktop\\testimport7.csv");
            // fs7.createNewFile();

            // initialise connection
            connectionResult = company.connect();

            // if connection successful
            if (connectionResult == 0)
            {
                //File fs10 = new File("C:\\Users\\admin_creh\\Desktop\\testimport10.csv");
                // fs10.createNewFile();
                System.out.println("Successfully connected to " + company.getCompanyName());

            }
            // if connection failed
            else
            {
                // get error message fom SAP Business One Server
                SBOErrorMessage errMsg = company.getLastError();




                System.out.println(
                        "Cannot connect to server: "
                                + errMsg.getErrorMessage()
                                + " "
                                + errMsg.getErrorCode()
                );
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();


            connectionResult = -1;
            return connectionResult;
        }

        return connectionResult;
    }


    public void disconnect()
    {
        company.disconnect();
        System.out.println("Application disconnected successfully");
    }


}
