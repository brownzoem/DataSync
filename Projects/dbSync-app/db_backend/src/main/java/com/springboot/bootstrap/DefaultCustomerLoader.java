package com.springboot.bootstrap;

import com.github.javafaker.Faker;
import com.springboot.entity.cbEntity.CbCustomer;
import com.springboot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//lombok annotation
@Slf4j
//spring annotation
@Component
public class DefaultCustomerLoader implements CommandLineRunner {

    @Autowired
    private CustomerService service;

    @Autowired
    Faker faker;

    @Override
    public void run(String... args) {
        final long count = service.count();
        if (count == 0) {
            log.info("Saving default customers in the couchbase");
            for (int i = 0; i < 10; i++) {
                persist();
            }
        } else {
            log.info("{} customers(s) already present in the couchbase", count);
        }
    }

    //save employee in the couchbase
    private void persist() {
        final CbCustomer e = create();
        service.save(e);
    }

    //create dummy employee
    private CbCustomer create() {
  //      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return CbCustomer.builder()
                .first_name(faker.name().firstName())
                .last_name(faker.name().lastName())
                .age(faker.random().nextInt(21, 51))
                .address(faker.address().fullAddress())
                .phone_number(faker.phoneNumber().phoneNumber())
                .job(faker.job().field())
                .input_time(sdf3.format(new Timestamp(System.currentTimeMillis())))
                .build();
    }
}
