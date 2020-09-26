package com.buchi.sapcustomer.service;

import com.buchi.sapcustomer.repository.CustomerRepository;
import com.buchi.sapcustomer.sapmodule.CustomerCreator;
import com.buchi.sapcustomer.web.mapper.CustomerMapper;
import com.buchi.sapcustomer.web.model.CustomerDto;
import com.sap.smb.sbo.api.SBOCOMException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;



@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService
{

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;


    @Override
    public CustomerDto postCustomerService(CustomerDto customerDto) throws IOException, SBOCOMException
    {


        //log.info(customerMapper.customerDtoToCustomer(customerDto).getPhone1());
        //
         customerRepository.save(customerMapper.customerDtoToCustomer(customerDto));

        /*CustomerCreator customerCreator = new CustomerCreator();
        int connectionResult = -1;
        while(connectionResult == -1)
        {
            connectionResult = customerCreator.connect(companyCode);
        }
        customerCreator.createBusinessPartner(companyCode,customerDto);
        if(connectionResult == 0)
        {
            customerCreator.disconnect();
        } */




        return null;
    }
}
