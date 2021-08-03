package com.interview.orderservice.impl;

import com.interview.orderservice.model.OrderRequest;
import com.interview.orderservice.model.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class SubmitOrderImplTest {
    @Test
    public void costIsCalculatedCorrectly() {
        //Given
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOranges(4);
        orderRequest.setApples(3);

        //When
        SubmitOrderImpl submitOrder = new SubmitOrderImpl();
        OrderResponse orderResponse = submitOrder.submitOrder(orderRequest);

        //Then
        assertThat(orderResponse.getStatus()).isEqualTo("success");

        BigDecimal expectedAppleValue = BigDecimal.valueOf(1.20).setScale(2, RoundingMode.HALF_UP);

        BigDecimal expectedOrangeValue = BigDecimal.valueOf(.75).setScale(2, RoundingMode.HALF_UP);
        BigDecimal expectedValue = BigDecimal.valueOf(1.95).setScale(2, RoundingMode.HALF_UP);

        assertThat(orderResponse.getTotalCost()).isEqualTo(expectedValue);
        assertThat(orderResponse.getAppleCost()).isEqualTo(expectedAppleValue);
        assertThat(orderResponse.getOrangeCost()).isEqualTo(expectedOrangeValue);


    }

    @Test
    public void costIsZeroWhenNoInput() {
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

    @Test
    public void costForOrangesOnly() {
        //Given
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOranges(6);

        //When
        SubmitOrderImpl submitOrder = new SubmitOrderImpl();
        OrderResponse orderResponse = submitOrder.submitOrder(orderRequest);

        //Then
        assertThat(orderResponse.getStatus()).isEqualTo("success");

        BigDecimal expectedOrangeValue = BigDecimal.valueOf(1.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal expectedValue = BigDecimal.valueOf(1.00).setScale(2, RoundingMode.HALF_UP);

        assertThat(orderResponse.getTotalCost()).isEqualTo(expectedValue);
        assertThat(orderResponse.getOrangeCost()).isEqualTo(expectedOrangeValue);

    }

    @Test
    public void costForApplesOnly() {
        //Given
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setApples(7);

        //When
        SubmitOrderImpl submitOrder = new SubmitOrderImpl();
        OrderResponse orderResponse = submitOrder.submitOrder(orderRequest);

        //Then
        assertThat(orderResponse.getStatus()).isEqualTo("success");

        BigDecimal expectedAppleValue = BigDecimal.valueOf(2.40).setScale(2, RoundingMode.HALF_UP);
        BigDecimal expectedValue = expectedAppleValue;

        assertThat(orderResponse.getTotalCost()).isEqualTo(expectedValue);
        assertThat(orderResponse.getAppleCost()).isEqualTo(expectedAppleValue);

    }


}
