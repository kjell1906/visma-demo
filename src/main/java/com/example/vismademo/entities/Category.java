package com.example.vismademo.entities;
import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_sequence"
    )
    private Integer id;

    // Category has a name
    private String name;

    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
