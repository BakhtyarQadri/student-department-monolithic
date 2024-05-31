package com.techlogix.training.controller;

import com.techlogix.training.dto.StudentDto;
import com.techlogix.training.exception.DataNotFoundException;
import com.techlogix.training.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private String addStudent(@RequestBody @Valid StudentDto studentDto) throws DataNotFoundException, BadRequestException {
        return studentService.addStudent(studentDto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private StudentDto getStudentById(@PathVariable Integer id) throws DataNotFoundException {
        return studentService.getStudentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private String deleteStudent(@PathVariable Integer id) throws DataNotFoundException {
        return studentService.deleteStudent(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private String updateStudent(@PathVariable Integer id, @RequestBody @Valid StudentDto studentDto) throws DataNotFoundException {
        return studentService.updateStudent(id, studentDto);

        // String resp = studentService.updateStudent(id, studentDto);
        // return new ResponseEntity<>(resp, HttpStatus.OK);
        // return ResponseEntity.ok().body(resp);
    }

}
