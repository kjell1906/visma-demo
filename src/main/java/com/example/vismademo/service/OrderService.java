package com.example.vismademo.service;

import com.example.vismademo.dtos.CartDTO;
import com.example.vismademo.dtos.OrderlineRequestDTO;

public interface OrderService {

    String createOrder(OrderlineRequestDTO[] orderlineRequestDTOS);

    CartDTO getOrder(int orderId);
}
