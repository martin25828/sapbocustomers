package com.buchi.sapcustomer.web.controller;


import com.buchi.sapcustomer.service.BusinessPartnerService;
import com.buchi.sapcustomer.service.CustomerService;
import com.buchi.sapcustomer.web.model.CustomerDto;
import com.sap.smb.sbo.api.SBOCOMException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/customer/")
public class CustomerController
{
    CustomerService customerService;


    @PostMapping()
    public ResponseEntity<CustomerDto> postCustomer(@RequestBody CustomerDto customerDto) throws IOException, SBOCOMException
    {

        return new ResponseEntity<CustomerDto>(customerService.postCustomerService(customerDto), HttpStatus.CREATED );
    }

}
