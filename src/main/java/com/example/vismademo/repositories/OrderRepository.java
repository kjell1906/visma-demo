package com.example.vismademo.repositories;

import com.example.vismademo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Cart, Integer> {
}
