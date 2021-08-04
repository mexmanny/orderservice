package com.interview.orderservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Document(collection = "orders")
public class OrderResponse {
    @Id
    String orderId;
    String status;
    BigDecimal appleCost;
    BigDecimal orangeCost;
    BigDecimal totalCost;

    public BigDecimal getAppleCost() {
        return appleCost;
    }

    public void setAppleCost(BigDecimal appleCost) {
        this.appleCost = appleCost;
    }

    public BigDecimal getOrangeCost() {
        return orangeCost;
    }

    public void setOrangeCost(BigDecimal orangeCost) {
        this.orangeCost = orangeCost;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
