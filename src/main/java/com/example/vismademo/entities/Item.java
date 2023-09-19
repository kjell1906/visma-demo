package com.example.vismademo.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_id_sequence",
            sequenceName = "item_id_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_sequence"
    )
    private Integer id;
    @Column(nullable = true)
    private String itemNumber;
    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private Integer weight;

    @Column(nullable = true)
    private String color;

    @Column(nullable = true)
    private String flavor;

    @Column(nullable = false)
    private Integer price;

    // Added items to category
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    // An item can have different discounts.
    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Discount> discounts;

    public Item() {
        this.discounts = new ArrayList<>();
    }

    public Item(Integer id, String itemNumber, String description, Integer weight, String color, String flavor, Category category) {
        this.id = id;
        this.itemNumber = itemNumber;
        this.description = description;
        this.weight = weight;
        this.color = color;
        this.flavor = flavor;
        this.category = category;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
