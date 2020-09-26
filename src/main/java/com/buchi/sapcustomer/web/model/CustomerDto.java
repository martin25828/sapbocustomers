package com.buchi.sapcustomer.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto
{

    private String companyCode;
    private String cardName;
    private String groupCode;
    private String currency;
    private String phone1;
    private String webside;
    private String incoterms;
    private String industry;
    private String salesEmployee;
    private String status;
    private String paymentTerms;

    // BillTo Address
    private String billToAddressId;
    private String billToAddress;
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
    private String shipToAddress;
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



}
