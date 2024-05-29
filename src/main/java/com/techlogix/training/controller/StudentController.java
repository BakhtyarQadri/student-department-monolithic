package com.techlogix.training.controller;

import com.techlogix.training.dto.StudentDto;
import com.techlogix.training.exception.DataNotFoundException;
import com.techlogix.training.service.StudentService;
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
