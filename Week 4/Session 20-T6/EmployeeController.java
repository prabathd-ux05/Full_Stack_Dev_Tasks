package com.example.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public String getEmployee() {
        return "Employee Details: ID=101, "
        		+ "Name=Prabath, "
        		+ "Department=CSE(AI & ML), "
        		+ "Salary=150000";
    }
}
