package com.example.vismademo.repositories;

import com.example.vismademo.entities.Discount;
import com.example.vismademo.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiscountRepository  extends JpaRepository<Discount, Integer> {

}
