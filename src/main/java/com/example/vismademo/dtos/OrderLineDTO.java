package com.example.vismademo.dtos;

/**
 * The DTO classes is used to only expose data we want to expose. This prevents us for exposing the Entity data.
 * and gives us an opportunity to hide sensitive data from outside world.
 */
public class OrderLineDTO {

    public String itemNumber;
    private String product;
    private String discount;
    private Integer percentage;


    public OrderLineDTO() {
    }

    public OrderLineDTO(String product, String discount, Integer percentage) {
        this.product = product;
        this.discount = discount;
        this.percentage = percentage;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
