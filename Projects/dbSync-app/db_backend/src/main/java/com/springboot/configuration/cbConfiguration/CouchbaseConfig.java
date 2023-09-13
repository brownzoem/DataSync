package com.springboot.configuration.cbConfiguration;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Primary;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.Locale;

//from Official Couchbase documentation -> difference reference
@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.springboot.repository.cbRepository"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "maithi123";
    }

    @Override
    public String getBucketName() {
        return "default";
    }

    @Bean
    public Faker faker() {
        return new Faker(new Locale("en-US"));
    }
}