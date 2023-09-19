package com.example.vismademo.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Discount {

    @Id
    @SequenceGenerator(
            name = "discount_id_sequence",
            sequenceName = "discount_id_sequence", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "discount_id_sequence"
    )
    private Integer id;

    private String name;

    private Integer percentage;

    @ManyToOne
    @JoinColumn(name="member_id", nullable=false)
    private Member member;



    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;
    public Discount() {

    }

    public Discount(Integer id, String name, Integer percentage, Member member, Item item) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.member = member;
        this.item = item;
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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
