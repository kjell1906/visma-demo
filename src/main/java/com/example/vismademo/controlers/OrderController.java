package com.example.vismademo.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class OrderController {

    @GetMapping("/")
    public String usage(){
        return "use /get_order to get order details and /create_order to create new.";
    }

    @GetMapping("/get_order")
    public String getOrder(){
        return "Order List";
    }

    @PostMapping("/create_order")
    public String createOrder(){
        return "Create Order";
    }
}
