package com.example.jdbcdemo.controller;

import com.example.jdbcdemo.model.Student;
import com.example.jdbcdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // CREATE
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // READ ALL
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    // =============================
    // CUSTOM QUERY METHODS (TASK 5.4)
    // =============================

    // Get by department
    @GetMapping("/students/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return studentRepository.findByDepartment(dept);
    }

    // Get by age
    @GetMapping("/students/age/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

    // Get by department AND age
    @GetMapping("/students/filter/{dept}/{age}")
    public List<Student> getByDeptAndAge(@PathVariable String dept, @PathVariable int age) {
        return studentRepository.findByDepartmentAndAgeGreaterThan(dept, age);
    }
}