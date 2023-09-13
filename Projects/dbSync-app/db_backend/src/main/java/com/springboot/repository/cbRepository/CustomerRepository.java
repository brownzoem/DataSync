package com.springboot.repository.cbRepository;

import com.springboot.entity.cbEntity.CbCustomer;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//couchbase annotations
//@N1qlPrimaryIndexed
//@ViewIndexed(designDoc = "cbcustomer")
//spring annotation
@Repository
public interface CustomerRepository extends CrudRepository<CbCustomer,String>{
//    Add the following code to the repository interface to define the SQL CRUD functionality.
//    The interface will be annotated with the couchbase server and the spring framework stereotype annotations.

//    List<Customer> findALL();

}
