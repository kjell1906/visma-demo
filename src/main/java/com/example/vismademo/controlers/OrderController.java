package com.example.vismademo.controlers;

import com.example.vismademo.dtos.CartDTO;
import com.example.vismademo.dtos.OrderLineDTO;
import com.example.vismademo.dtos.OrderlineRequestDTO;
import com.example.vismademo.entities.Cart;
import com.example.vismademo.entities.Discount;
import com.example.vismademo.entities.Item;
import com.example.vismademo.entities.OrderLine;
import com.example.vismademo.repositories.*;
import com.example.vismademo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String usage(){
        return "use /get_order to get order details and /create_order to create new.";
    }

    //record OrderLineDTO (String product, String discount) {}
    @GetMapping("/get_order")
    public List<OrderLineDTO> getOrder(@RequestParam Integer id){

        // Send request to database to get order lines and product details
        return orderService.getOrder(id).getOrderLines();

    }

    @PostMapping("/create_order")
    public String createOrder(@RequestBody OrderlineRequestDTO[] orderlineRequestDTO){

        // Send request details to orderService to store in database
        return orderService.createOrder(orderlineRequestDTO);

    }
}
