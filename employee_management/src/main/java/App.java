package com.example.employee;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        BeanFactory factory =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeService service =
                factory.getBean(EmployeeService.class);

        service.createEmployee(1, "Alice", "IT");
        service.createEmployee(2, "Bob", "HR");

        service.showEmployees();
    }
}
