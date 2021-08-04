package com.interview.orderservice.impl;

import com.interview.orderservice.model.OrderRequest;
import com.interview.orderservice.model.OrderResponse;
import com.interview.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class SubmitOrderImpl {
    @Autowired
    OrderRepository orderRepository;
    private static final BigDecimal APPLE_COST = BigDecimal.valueOf(.60);
    private static final BigDecimal ORANGE_COST = BigDecimal.valueOf(.25);

    public OrderResponse submitOrder(OrderRequest orderRequest) {

        BigDecimal appleCost = calculateAppleCost(orderRequest.getApples());
        BigDecimal orangeCost = calculateOrangeCost(orderRequest.getOranges());
        BigDecimal totalCost = appleCost.add(orangeCost);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("success");
        orderResponse.setAppleCost(appleCost);
        orderResponse.setOrangeCost(orangeCost);
        orderResponse.setTotalCost(totalCost.setScale(2, RoundingMode.HALF_UP));
            return orderResponse;

    }



    private BigDecimal calculateAppleCost(int appleCount) {
        BigDecimal appleCost = BigDecimal.valueOf(0.00);
        if (appleCount > 0) {
            BigDecimal dealApples = new BigDecimal(appleCount / 2).multiply(APPLE_COST);
            BigDecimal remainderApples = new BigDecimal(appleCount % 2).multiply(APPLE_COST);
            appleCost = dealApples.add(remainderApples);
            return appleCost.setScale(2, RoundingMode.HALF_UP);
        }

        return appleCost;
    }

    private BigDecimal calculateOrangeCost(int orangeCount) {
        BigDecimal orangeCost = BigDecimal.valueOf(0.00);
        if (orangeCount > 0) {

            if (orangeCount % 3 == 0) {

                orangeCost = new BigDecimal((orangeCount / 3) * 2).multiply(ORANGE_COST);
            } else {
                BigDecimal dealOranges = new BigDecimal((orangeCount / 3) * 2).multiply(ORANGE_COST);
                BigDecimal remainderOranges = new BigDecimal(orangeCount % 3).multiply(ORANGE_COST);
                orangeCost = dealOranges.add(remainderOranges);
            }

            return orangeCost.setScale(2, RoundingMode.HALF_UP);
        }
        return orangeCost;
    }
}
