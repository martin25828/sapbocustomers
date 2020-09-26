package com.buchi.sapcustomer.service;

import com.buchi.sapcustomer.web.model.CustomerDto;
import com.sap.smb.sbo.api.SBOCOMException;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public interface CustomerService
{
    CustomerDto postCustomerService(CustomerDto customerDto) throws IOException, SBOCOMException;
}
