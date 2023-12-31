package com.example.vismademo.dtos;

import com.example.vismademo.entities.OrderLine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The DTO classes is used to only expose data we want to expose. This prevents us for exposing the Entity data.
 * and gives us an opportunity to hide sensitive data from outside world.
 */
public class CartDTO {

    private Integer id;

    private Date orderDate;

    private List<OrderLineDTO> orderLines;

    public CartDTO() {
        orderLines = new ArrayList<OrderLineDTO>();
    }

    public CartDTO(Integer id, Date orderDate, List<OrderLineDTO> orderLines) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderLines = orderLines;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderLineDTO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineDTO> orderLines) {
        this.orderLines = orderLines;
    }
}
