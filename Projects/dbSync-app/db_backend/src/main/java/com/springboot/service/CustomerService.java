package com.springboot.service;
import com.springboot.entity.cbEntity.CbCustomer;
import com.springboot.exception.EntityNotFound;
import com.springboot.repository.cbRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//spring annotation
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    //save new employee in the couchbase
    public void save(final CbCustomer e) {
        repository.save(e);
    }

    //get total count in the couchbase
    public long count() {
        return 0;
    }

    //get all employees from the couchbase
    public List<CbCustomer> getCustomers() {
        final Iterable<CbCustomer> customerIterable = repository.findAll();
        return StreamSupport.stream(customerIterable.spliterator(), false).collect(Collectors.toList());
    }

    //get employee by id from the couchbase
    public CbCustomer getCustomer(final String cid) throws EntityNotFound {
        return repository.findById(cid).orElseThrow(EntityNotFound::new);
    }

    //get employees by department from the couchbase
//    public List<Customer> getCustomerByJob(final String job) {
//        return repository.findAllByJob(job);
//    }
}
