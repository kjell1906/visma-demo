package com.example.vismademo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @SequenceGenerator(
            name = "member_id_sequence",
            sequenceName = "member_id_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_id_sequence"
    )
    private int id;

    // Member has a name in startup
    private String name;

    @OneToMany(mappedBy="member")
    private List<Discount> discounts;

    public Member() {
        discounts = new ArrayList<Discount>();
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Discount> getDiscount() {
        return discounts;
    }

//    public void setDiscount(List<Discount> discount) {
//        this.discounts = discounts;
//    }
}
