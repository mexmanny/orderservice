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

        BigDecimal appleCost = calculateAppleCost (orderRequest.getApples(), orderRequest);
        BigDecimal orangeCost = calculateOrangeCost(orderRequest.getOranges(),orderRequest);
        BigDecimal totalCost = appleCost.add(orangeCost);


        Random random = new Random();
        int number = random.nextInt(Integer.MAX_VALUE);


        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setOrderId(number);
        orderResponse.setStatus("success");
        orderResponse.setAppleCost(appleCost.setScale(2, RoundingMode.HALF_UP));
        orderResponse.setOrangeCost(orangeCost);
        orderResponse.setTotalCost(totalCost.setScale(2, RoundingMode.HALF_UP));

        return orderResponse;
    }

    private BigDecimal calculateAppleCost (int appleCount, OrderRequest orderRequest) {
        BigDecimal appleCost = BigDecimal.valueOf(0.00);
        if (appleCount>0) {
            BigDecimal dealApples = new BigDecimal (appleCount/2).multiply(APPLE_COST);
            BigDecimal remainderApples = new BigDecimal (appleCount%2).multiply(APPLE_COST);
            appleCost = dealApples.add(remainderApples);
            return appleCost;
        }

        return appleCost;
    }

    private BigDecimal calculateOrangeCost (int orangeCount, OrderRequest orderRequest) {
        BigDecimal orangeCost = BigDecimal.valueOf(0.00);
        if (orangeCount>0) {

            if(orangeCount%3==0){

                orangeCost = new BigDecimal((orangeCount/3) * 2).multiply( ORANGE_COST);
            } else {
                BigDecimal dealOranges = new BigDecimal ((orangeCount/3) * 2).multiply(ORANGE_COST);
                BigDecimal remainderOranges = new BigDecimal (orangeCount%3).multiply(ORANGE_COST);
                orangeCost = dealOranges.add(remainderOranges);
            }

            return orangeCost.setScale(2, RoundingMode.HALF_UP);
        }
        return orangeCost;
    }
}
