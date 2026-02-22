package com.example.optionalinjectiondemo.controller;

import com.example.optionalinjectiondemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String order(@RequestParam String item) {
        return orderService.placeOrder(item);
    }
}
