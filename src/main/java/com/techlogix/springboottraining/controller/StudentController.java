package com.techlogix.springboottraining.controller;

import com.techlogix.springboottraining.dto.StudentDto;
import com.techlogix.springboottraining.exception.DataNotFoundException;
import com.techlogix.springboottraining.service.StudentService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    private String addStudent(@RequestBody @Valid StudentDto studentDto) throws DataNotFoundException, BadRequestException {
        return studentService.addStudent(studentDto);
    }

    @GetMapping("{id}")
    private StudentDto getStudentById(@PathVariable Integer id) throws DataNotFoundException {
        return studentService.getStudentById(id);
    }

    @GetMapping
    private List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @DeleteMapping("{id}")
    private String deleteStudent(@PathVariable Integer id) throws DataNotFoundException {
        return studentService.deleteStudent(id);
    }

    @PutMapping("{id}")
    private String updateStudent(@PathVariable Integer id, @RequestBody @Valid StudentDto studentDto) throws DataNotFoundException {
        return studentService.updateStudent(id, studentDto);
    }

}
