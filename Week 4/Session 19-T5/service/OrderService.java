package com.example.optionalinjectiondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired(required = false)
    private AuditService auditService;

    public String placeOrder(String item) {

        if (auditService != null) {
            auditService.audit("Order placed for: " + item + "And order is Placed for Prabath");
        } else {
            System.out.println("AuditService not available");
        }

        return "Order successful for " + item + "And order is Placed for Prabath";
    }
}
