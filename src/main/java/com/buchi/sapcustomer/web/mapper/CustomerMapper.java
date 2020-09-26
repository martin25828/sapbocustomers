package com.buchi.sapcustomer.web.mapper;

import com.buchi.sapcustomer.domain.Customer;
import com.buchi.sapcustomer.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper
{
    public Customer customerDtoToCustomer(CustomerDto customerDto);
    public CustomerDto customerToCustomerDto(Customer customer);
}
