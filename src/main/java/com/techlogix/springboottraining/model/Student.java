package com.techlogix.springboottraining.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity // without it JPA does not work + we could not create table in db automatically
@Getter  // without it when we use POST request we can't get our fields data in controller
@Setter
public class Student {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Integer id;

    private String name;
    private String email;
    private Integer age;

    // @Column(name = "dept_fid")
     @ManyToOne() // fetch = FetchType.LAZY , cascade = CascadeType.ALL
     @JoinColumn(name = "dept_fid", nullable = false) // referencedColumnName = "id"
     private Department department;
}
