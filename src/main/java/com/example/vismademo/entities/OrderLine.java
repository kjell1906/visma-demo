package com.example.vismademo.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderLine {

    @Id
    @SequenceGenerator(
            name = "line_id_sequence",
            sequenceName = "line_id_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "line_id_sequence"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    @ManyToOne
    @JoinColumn(name="discount_id", nullable=false)
    private Discount discount;

    private int quantity;
    private int lineAmount;

    public OrderLine() {
    }

    public OrderLine(Integer id, Cart cart, int quantity, int lineAmount) {
        this.id = id;
        this.cart = cart;
        this.quantity = quantity;
        this.lineAmount = lineAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getOrder() {
        return cart;
    }

    public void setOrder(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(int lineAmount) {
        this.lineAmount = lineAmount;
    }
}
