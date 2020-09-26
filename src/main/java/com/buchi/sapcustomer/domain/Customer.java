package com.buchi.sapcustomer.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;


    @Column(name = "errorMessage", columnDefinition = "nvarchar(max)")
    private String errorMessage;

    @Column(name="companyCode", columnDefinition = "nvarchar(200)")
    private String companyCode;

    @Column(name = "cardName", columnDefinition = "nvarchar(200)")
    private String cardName;

    @Column(name = "groupCode", columnDefinition = "nvarchar(200)")
    private String groupCode;
    @Column(name = "currency", columnDefinition = "nvarchar(200)")
    private String currency;
    @Column(name = "phone1", columnDefinition = "nvarchar(200)")
    private String phone1;
    @Column(name = "webside", columnDefinition = "nvarchar(200)")
    private String webside;
    @Column(name = "incoterms", columnDefinition = "nvarchar(200)")
    private String incoterms;
    @Column(name = "industry", columnDefinition = "nvarchar(200)")
    private String industry;
    @Column(name = "salesEmployee", columnDefinition = "nvarchar(200)")
    private String salesEmployee;
    @Column(name = "status", columnDefinition = "nvarchar(200)")
    private String status;
    @Column(name = "paymentTerms", columnDefinition = "nvarchar(200)")
    private String paymentTerms;

    // BillTo Address
    @Column(name = "billToAddressId", columnDefinition = "nvarchar(200)")
    private String billToAddressId;
    @Column(name = "billToAddress", columnDefinition = "nvarchar(200)")
    private String billToAddress;
    @Column(name = "billToAddress2", columnDefinition = "nvarchar(200)")
    private String billToAddress2;
    @Column(name = "billToAddress3", columnDefinition = "nvarchar(200)")
    private String billToAddress3;
    @Column(name = "billToStreet", columnDefinition = "nvarchar(200)")
    private String billToStreet;
    @Column(name = "billToStreetNumber", columnDefinition = "nvarchar(200)")
    private String billToStreetNumber;
    @Column(name = "billToBuilding", columnDefinition = "nvarchar(200)")
    private String billToBuilding;
    @Column(name = "billToPostCode", columnDefinition = "nvarchar(200)")
    private String billToPostCode;
    @Column(name = "billToCity", columnDefinition = "nvarchar(200)")
    private String billToCity;
    @Column(name = "billToState", columnDefinition = "nvarchar(200)")
    private String billToState;
    @Column(name = "billToCounty", columnDefinition = "nvarchar(200)")
    private String billToCounty;
    @Column(name = "billToCountry", columnDefinition = "nvarchar(200)")
    private String billToCountry;

    //U_COR_BU_CRMGUID
    @Column(name = "billToGlobalIdentificationCode", columnDefinition = "nvarchar(200)")
    private String billToGlobalIdentificationCode;
    //U_COR_BU_CompName
    @Column(name = "billToCompanyName", columnDefinition = "nvarchar(200)")
    private String billToCompanyName;



    // ShipTo Address
    @Column(name = "shipToAddressId", columnDefinition = "nvarchar(200)")
    private String shipToAddressId;
    @Column(name = "shipToAddress", columnDefinition = "nvarchar(200)")
    private String shipToAddress;
    @Column(name = "shipToAddress2", columnDefinition = "nvarchar(200)")
    private String shipToAddress2;
    @Column(name = "shipToAddress3", columnDefinition = "nvarchar(200)")
    private String shipToAddress3;
    @Column(name = "shipToStreet", columnDefinition = "nvarchar(200)")
    private String shipToStreet;
    @Column(name = "shipToStreetNumber", columnDefinition = "nvarchar(200)")
    private String shipToStreetNumber;
    @Column(name = "shipToBuilding", columnDefinition = "nvarchar(200)")
    private String shipToBuilding;
    @Column(name = "shipToPostCode", columnDefinition = "nvarchar(200)")
    private String shipToPostCode;
    @Column(name = "shipToCity", columnDefinition = "nvarchar(200)")
    private String shipToCity;
    @Column(name = "shipToState", columnDefinition = "nvarchar(200)")
    private String shipToState;
    @Column(name = "shipToCounty", columnDefinition = "nvarchar(200)")
    private String shipToCounty;
    @Column(name = "shipToCountry", columnDefinition = "nvarchar(200)")
    private String shipToCountry;
    @Column(name = "shipToGlobalIdentificationCode", columnDefinition = "nvarchar(200)")
    private String shipToGlobalIdentificationCode;
    @Column(name = "shipToCompanyName", columnDefinition = "nvarchar(200)")
    private String shipToCompanyName;
}
