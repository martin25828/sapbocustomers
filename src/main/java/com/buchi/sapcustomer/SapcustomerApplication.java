package com.buchi.sapcustomer;

import com.buchi.sapcustomer.sapmodule.CustomerCreator;
import com.buchi.sapcustomer.scheduler.BusinessPartnerScheduler;
import com.buchi.sapcustomer.web.model.CustomerDto;
import org.quartz.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SyncTaskExecutor;

@SpringBootApplication
public class SapcustomerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SapcustomerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        /*CustomerCreator customerCreator = new CustomerCreator();
        customerCreator.createBusinessPartner("BUS", customerDto);*/
    }


    @Bean
    public JobDetail BPJobDetail()
    {

        return JobBuilder.newJob(BusinessPartnerScheduler.class).withIdentity("BusinessPartnerTask")
                .usingJobData("BusinessPartnerTask", "BusinessPartnerTask").storeDurably().build();


    }

    @Bean
    public Trigger BPJobTrigger()
    {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(1).repeatForever().withRepeatCount(1);
        return TriggerBuilder.newTrigger().forJob(BPJobDetail()).withIdentity("BusinessPartnerTask").withSchedule(scheduleBuilder).build();
    }

}
