package com.example.jdbcdemo.repository;

import com.example.jdbcdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByDepartment(String department);

    List<Student> findByAgeGreaterThan(int age);

    List<Student> findByDepartmentAndAgeGreaterThan(String department, int age);
}