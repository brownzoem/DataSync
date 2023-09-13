package com.springboot.controller;

import com.springboot.entity.pgEntity.PgCustomer;
import com.springboot.repository.pgRepository.PostgresRepo;
//import com.springboot.service.pgService.PostgresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class PostgresController {

    @Autowired
    private PostgresRepo repository;

    @GetMapping("/customers")
   // @ResponseStatus(HttpStatus.OK)
    public List<PgCustomer> getAllTutorials() {
        return repository.findAll();
    }

    @GetMapping("/min-val")
    public List<Object> getMinVal() { return repository.min_val();}

  //  @GetMapping("/avg-val")
 //   public List<Double> getAvgVal() { return repository.avg_val();}
//
//    @GetMapping("/max-val")
//    public List<Double> getMaxVal() { return repository.max_val();}

}
