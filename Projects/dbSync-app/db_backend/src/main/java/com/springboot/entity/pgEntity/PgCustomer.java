package com.springboot.entity.pgEntity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class PgCustomer {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private String id;
    //denotes a field which in the couchbase document
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="address")
    private String address;
    @Column(name="job")
    private String job;
    @Column(name="input_time")
    private Timestamp inputTime;
    @Column(name="output_time")
    private Timestamp outputTime;
}
