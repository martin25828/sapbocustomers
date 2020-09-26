package com.buchi.sapcustomer.repository;

import com.buchi.sapcustomer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>
{
   List<Customer> findAllByCompanyCode(String companyCode);

}
