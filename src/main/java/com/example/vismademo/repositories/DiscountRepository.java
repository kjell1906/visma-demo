package com.example.vismademo.repositories;

import com.example.vismademo.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository  extends JpaRepository<Discount, Integer> {
}
