package com.techlogix.springboottraining.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Department {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Integer id;
    private String name;

    // @Column(name = "student_fid")
//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Student> students;
}
