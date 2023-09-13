/*package com.springboot.service.pgService;

import com.springboot.entity.pgEntity.PgCustomer;
import com.springboot.repository.pgRepository.PostgresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostgresService {
    @Autowired
    private PostgresRepo repository;

    public List<PgCustomer> getAllCustomers() {
        final Iterable<PgCustomer> customerIterable = repository.findAll();
        return StreamSupport.stream(customerIterable.spliterator(), false).collect(Collectors.toList());
    }
}*/
