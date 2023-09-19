package com.example.vismademo.service;

import com.example.vismademo.entities.OrderLine;
import com.example.vismademo.repositories.OrderLineRepository;

import java.util.List;

public interface OrderLineService {

    void save(List<OrderLine> orderLines);


}
