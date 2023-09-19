package com.example.vismademo.service;

import com.example.vismademo.entities.OrderLine;
import com.example.vismademo.repositories.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService{

    private final OrderLineRepository orderLineRepository;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public void save(List<OrderLine> orderLines) {
        orderLineRepository.saveAll(orderLines);
    }
}
