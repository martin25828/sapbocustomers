package com.buchi.sapcustomer.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShipToAddress
{

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

}
