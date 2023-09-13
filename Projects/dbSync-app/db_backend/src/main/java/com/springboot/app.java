package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//lombok annotation
@Slf4j
//spring annotation - bootstrap the application from the main method, is the entry point of the application
@SpringBootApplication
//@ComponentScan(basePackages = {"com.springboot.configuration.pgConfiguration", "com.springboot.configuration.cbConfiguration", "com.springboot.controller", "com.springboot.bootstrap"})
//@ComponentScan(basePackages = {"com.springboot.configuration.pgConfiguration", "com.springboot.configuration.cbConfiguration"})
//@EnableJpaRepositories(basePackages = {"com.springboot.repository.pgRepository"})
//@EntityScan(basePackages = {"com.springboot.entity.cbEntity", "com.springboot.entity.pgEntity"})
public class app {
    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
        log.info("springboot and couchbase application started successfully");
    }
}
