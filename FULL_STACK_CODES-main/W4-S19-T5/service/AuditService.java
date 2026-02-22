package com.example.optionalinjectiondemo.service;

import org.springframework.stereotype.Component;

@Component
public class AuditService {

    public void audit(String message) {
        System.out.println("AUDIT: " + message);
    }
}
