/*
package com.springboot.couchbase.controller;

import com.springboot.couchbase.entity.Customer;
import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//lombok annotation
@Slf4j
//spring annotations
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService service;

    //URL - http://localhost:9300/api/customers
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers() {
        log.info("returning all customers from the couchbase");
        return service.getCustomers();
    }

    //URL - http://localhost:9300/api/employee/<eid>
    //Example - http://localhost:9300/api/employee/73a02968-70a8-426a-b6d8-deaa96a597df

    //URL - http://localhost:9300/api/employee/<work_department>
    //Example - http://localhost:9300/api/employees/Health


    //URL - http://localhost:9300/api/employees/count
    @GetMapping("/customer/count")
    @ResponseStatus(HttpStatus.OK)
    public long getTotalCustomers() {
        log.info("returning customers count from the couchbase");
        return service.count();
    }


}
*/
