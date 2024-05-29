package com.techlogix.training.service;

import com.techlogix.training.dto.StudentDto;
import com.techlogix.training.exception.DataNotFoundException;
import com.techlogix.training.model.Department;
import com.techlogix.training.model.Student;
import com.techlogix.training.repository.DepartmentRepo;
import com.techlogix.training.repository.StudentRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private DepartmentRepo departmentRepo;

    public String addStudent(StudentDto studentDto) throws DataNotFoundException, BadRequestException {
        Student existingStudent = studentRepo.findByEmail(studentDto.getEmail());
        if (existingStudent == null) {
            Student newStudent = getStudentEntity(studentDto);
            studentRepo.save(newStudent);
            return "Record Added";
        } else {
            throw new BadRequestException("user email already exist");
        }
    }

    public StudentDto getStudentById(Integer id) throws DataNotFoundException {
        Student student = studentRepo.findById(id).orElseThrow(() -> new DataNotFoundException("invalid student id"));
        return new StudentDto(student.getName(), student.getEmail(), student.getAge(), student.getDepartment().getId());
    }
//    public Optional<Student> getStudentById(Integer id) throws DataNotFoundException {
//        Optional<Student> student = studentRepo.findById(id);
//        if (student.isPresent()) {
//            return student;
//        } else {
//            throw new DataNotFoundException("invalid student id");
//        }
//    }

    public List<StudentDto> getStudents() {
        var students = studentRepo.findAll();
        var studentsList = new ArrayList<StudentDto>();
        for (Student student: students) {
            studentsList.add( new StudentDto(student.getName(), student.getEmail(), student.getAge(), student.getDepartment().getId()) );
        }
        return studentsList;
        // return studentRepo.findAll();
    }

    public String deleteStudent(Integer id) throws DataNotFoundException {
        StudentDto studentDto = getStudentById(id);
        studentRepo.deleteById(id);
        return "Record deleted";
    }

    public String updateStudent(Integer id, StudentDto studentDto) throws DataNotFoundException {
        StudentDto resp = getStudentById(id);
        Student student = getStudentEntity(studentDto);
        student.setId(id);
        studentRepo.save(student);
        return "Record Updated";
    }

    private Student getStudentEntity(StudentDto studentDto) throws DataNotFoundException {
        Department department = departmentRepo.findById(studentDto.getDepartmentId()).orElseThrow(() -> new DataNotFoundException("invalid department id"));
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        student.setDepartment(department);
        // Student student = new Student(
        //      studentDto.getName(),
        //      studentDto.getEmail(),
        //      studentDto.getAge(),
        //      department
        // );
        return student;
    }

}



