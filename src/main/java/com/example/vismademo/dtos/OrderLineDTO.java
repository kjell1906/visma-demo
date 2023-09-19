package com.example.vismademo.dtos;

public class OrderLineDTO {

    public String itemNumber;
    private String product;
    private String discount;

    public OrderLineDTO() {
    }

    public OrderLineDTO(String product, String discount) {
        this.product = product;
        this.discount = discount;
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
}
