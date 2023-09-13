package com.springboot.entity.cbEntity;

//import com.couchbase.client.java.repository.annotation.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;


//lombok annotations
@NoArgsConstructor
@AllArgsConstructor
@Builder
//identified the domain object to be persisted to couchbase
@Document
@Data
public class CbCustomer {
    // identifies a field which will not be stored in the couchbase document but rather used as document id
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;
    //denotes a field which in the couchbase document
    private String first_name;
    private String last_name;
    private int age;
    private String phone_number;
    private String address;
    private String job;
    private String input_time;

    //setters and getters

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getfirst_name() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getphone_number() {
        return phone_number;
    }

    public String getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public String getTime() {return input_time;}

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setTime(String time) {this.input_time = time;}

}
