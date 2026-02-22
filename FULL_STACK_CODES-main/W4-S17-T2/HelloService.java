package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getMessage() {
        return "Hello from Service Layer! This is Task 2";
    }
}
