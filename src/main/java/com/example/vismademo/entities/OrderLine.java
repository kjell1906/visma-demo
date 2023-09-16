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

    private Integer quantity;
    private Integer lineAmount;

    public OrderLine() {
    }

    public OrderLine(Integer id, Cart cart, Integer quantity, Integer lineAmount, Item item, Discount discount) {
        this.id = id;
        this.cart = cart;
        this.quantity = quantity;
        this.lineAmount = lineAmount;
        this.item = item;
        this.discount = discount;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Integer lineAmount) {
        this.lineAmount = lineAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
