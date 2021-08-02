package com.interview.orderservice.model;


import java.math.BigDecimal;

public class OrderResponse {
    int orderId;
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



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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
