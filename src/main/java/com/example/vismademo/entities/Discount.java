package com.example.vismademo.entities;
import jakarta.persistence.*;

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
    private int id;

    private String name;

    private int percentage;

    @ManyToOne
    @JoinColumn(name="member_id", nullable=false)
    private Member member;

    public Discount() {
    }

    public Discount(int id, String name, int percentage, Member member) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.member = member;
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

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
