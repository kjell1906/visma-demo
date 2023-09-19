package com.example.vismademo.dtos;

/**
 * The DTO classes is used to only expose data we want to expose. This prevents us for exposing the Entity data.
 * and gives us an opportunity to hide sensitive data from outside world.
 */
public class OrderlineRequestDTO {

    private String flavor;
    private String itemNumber;
    private Integer memberId;

    public OrderlineRequestDTO() {
    }

    public OrderlineRequestDTO(String flavor, String itemNumber, Integer memberId) {
        this.flavor = flavor;
        this.itemNumber = itemNumber;
        this.memberId = memberId;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
