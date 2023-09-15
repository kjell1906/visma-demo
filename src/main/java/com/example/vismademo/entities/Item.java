package com.example.vismademo.entities;
import jakarta.persistence.*;

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
    private int id;
    @Column(nullable = true)
    private String itemNumber;
    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private int weight;

    @Column(nullable = true)
    private String color;

    @Column(nullable = true)
    private String flavor;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    public Item() {
    }

    public Item(int id, String itemNumber, String description, int weight, String color, String flavor, Category category) {
        this.id = id;
        this.itemNumber = itemNumber;
        this.description = description;
        this.weight = weight;
        this.color = color;
        this.flavor = flavor;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
}
