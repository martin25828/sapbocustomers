package com.buchi.sapcustomer.scheduler;

import com.buchi.sapcustomer.domain.Customer;
import com.buchi.sapcustomer.repository.CustomerRepository;
import com.buchi.sapcustomer.sapmodule.CustomerCreator;
import com.buchi.sapcustomer.web.mapper.CustomerMapper;
import com.buchi.sapcustomer.web.model.CustomerDto;
import com.sap.smb.sbo.api.SBOCOMException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class BusinessPartnerScheduler extends QuartzJobBean
{

   // private String[] companyCodes = {"BUS", "BCN", "BDE", "BIT", "BFR", "BTH", "BHK","BID","BMY","BSG","BKR","BJP","BBR"};
    private String[] companyCodes = {"BSG"};



    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {


        log.info("Job Starts");



           System.out.println("job is running");
            for (String companyCode : companyCodes) {


                List<Customer> customerList = customerRepository.findAllByCompanyCode(companyCode);
                //System.out.println(customerList.size());

                if (customerList.size() > 0) {
                    try {
                        createBusinessPartner(companyCode, customerList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SBOCOMException e) {
                        e.printStackTrace();
                    }
                }

            }
            System.out.println("job is finish");




    }

    public void createBusinessPartner(String companyCode, List<Customer> customerList) throws IOException, SBOCOMException {

        CustomerCreator customerCreator = new CustomerCreator();
        int connectionResult = -1;



        for (Customer customer: customerList)
        {


            customerCreator.createBusinessPartner(companyCode, customerMapper.customerToCustomerDto(customer));


            if(customerCreator.getErrorCode() == 200)
            {
                customerRepository.delete(customer);
            }else
            {
                customer.setErrorMessage(customerCreator.getErrorMessage());
                customerRepository.save(customer);
            }



        }





    }


}
