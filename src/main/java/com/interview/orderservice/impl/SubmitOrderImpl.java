package com.interview.orderservice.impl;

import com.interview.orderservice.model.OrderRequest;
import com.interview.orderservice.model.OrderResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Component
public class SubmitOrderImpl {
    private static final BigDecimal APPLE_COST = BigDecimal.valueOf(.60);
    private static final  BigDecimal ORANGE_COST = BigDecimal.valueOf(.25);

    public OrderResponse submitOrder(OrderRequest orderRequest) {

        BigDecimal appleCost = new BigDecimal(orderRequest.getApples()).multiply(APPLE_COST);
        BigDecimal orangeCost = new BigDecimal (orderRequest.getOranges()).multiply(ORANGE_COST);
        BigDecimal totalCost = new BigDecimal("0.00");

        if (orderRequest.getOranges() > 0) {
            totalCost = orangeCost.add(totalCost);
        }

        if (orderRequest.getApples() >0) {
            totalCost = appleCost.add(totalCost);
        }

        Random random = new Random();
        int number = random.nextInt(Integer.MAX_VALUE);


        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setOrderId(number);
        orderResponse.setStatus("success");
        orderResponse.setTotalCost(totalCost.setScale(2, RoundingMode.HALF_UP));

        return orderResponse;
    }
}
