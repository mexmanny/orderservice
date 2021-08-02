package com.interview.orderservice.impl;

import com.interview.orderservice.model.OrderRequest;
import com.interview.orderservice.model.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class SubmitOrderImplTest {
    @Test
    public void costIsCalculatedCorrectly () {
        //Given
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOranges(4);
        orderRequest.setApples(3);

        //When
        SubmitOrderImpl submitOrder = new SubmitOrderImpl();
        OrderResponse orderResponse = submitOrder.submitOrder(orderRequest);

        //Then
        assertThat(orderResponse.getStatus()).isEqualTo("success");

        BigDecimal expectedAppleValue = BigDecimal.valueOf(1.2);
        //expectedAppleValue.setScale(2, RoundingMode.HALF_UP);
        System.out.println(expectedAppleValue);
        BigDecimal expectedOrangeValue = BigDecimal.valueOf(.75);
        System.out.println(expectedOrangeValue);
        BigDecimal expectedValue = BigDecimal.valueOf(1.95);

        expectedValue = expectedValue.setScale(2, RoundingMode.HALF_UP);

        assertThat(orderResponse.getTotalCost()).isEqualTo(expectedValue);
       // assertThat(orderResponse.getAppleCost()).isEqualTo(expectedAppleValue);
        assertThat(orderResponse.getOrangeCost()).isEqualTo(expectedOrangeValue);


    }

    @Test
    public void costIsZeroWhenNoInput () {
        //Given
        OrderRequest orderRequest = new OrderRequest();

        //When
        SubmitOrderImpl submitOrder = new SubmitOrderImpl();
        OrderResponse orderResponse = submitOrder.submitOrder(orderRequest);

        //Then
        assertThat(orderResponse.getStatus()).isEqualTo("success");
        BigDecimal expectedValue = BigDecimal.valueOf(0.00);
        expectedValue = expectedValue.setScale(2, RoundingMode.HALF_UP);
        assertThat(orderResponse.getTotalCost()).isEqualTo(expectedValue);


    }


}
