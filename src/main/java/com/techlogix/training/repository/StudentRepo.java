package com.techlogix.training.repository;

import com.techlogix.training.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
}
