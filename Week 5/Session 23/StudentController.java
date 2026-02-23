package com.example.jdbcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.jdbcdemo.model.Student;
import com.example.jdbcdemo.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // 🔹 CREATE
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // 🔹 READ ALL
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 🔹 READ ONE
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // 🔹 UPDATE
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student s = studentRepository.findById(id).orElse(null);
        if (s != null) {
            s.setName(student.getName());
            s.setAge(student.getAge());
            return studentRepository.save(s);
        }
        return null;
    }

    // 🔹 DELETE
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }
}