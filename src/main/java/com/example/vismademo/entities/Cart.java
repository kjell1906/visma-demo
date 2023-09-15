package com.example.vismademo.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Cart {

    @Id
    @SequenceGenerator(
            name = "cart_id_sequence",
            sequenceName = "cart_id_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_id_sequence"
    )
    private Integer id;

    private Date orderDate;

    @OneToMany(mappedBy = "cart")
    private List<OrderLine> orderLine;

}
