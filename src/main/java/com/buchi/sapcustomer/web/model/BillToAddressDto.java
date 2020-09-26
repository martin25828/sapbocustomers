package com.buchi.sapcustomer.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillToAddressDto
{


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

}
