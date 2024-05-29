package com.techlogix.training.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
