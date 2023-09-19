package com.example.vismademo.service;

import com.example.vismademo.entities.OrderLine;
import com.example.vismademo.repositories.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Using service to make the service loose coupled.
 * This gives us the option to use Service Layer in other services or controllers with just calling the service method to
 * get data from logic. We also hold the logic in methods in service class and have achieved code reuse and only one place to update the code.
 */
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
