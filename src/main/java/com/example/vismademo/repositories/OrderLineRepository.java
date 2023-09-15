package com.example.vismademo.repositories;

import com.example.vismademo.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository  extends JpaRepository<OrderLine, Integer> {
}
