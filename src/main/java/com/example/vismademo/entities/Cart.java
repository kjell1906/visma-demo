package com.example.vismademo.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
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

    public Cart() {
        orderLine = new ArrayList<OrderLine>();
    }

    public Cart(Integer id, Date orderDate, List<OrderLine> orderLine) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderLine = orderLine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }
}
