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
        orderRequest.setOranges(2);
        orderRequest.setApples(3);

        //When
        SubmitOrderImpl submitOrder = new SubmitOrderImpl();
        OrderResponse orderResponse = submitOrder.submitOrder(orderRequest);

        //Then
        assertThat(orderResponse.getStatus()).isEqualTo("success");
        BigDecimal expectedValue = BigDecimal.valueOf(2.30);
        expectedValue = expectedValue.setScale(2, RoundingMode.HALF_UP);
        assertThat(orderResponse.getTotalCost()).isEqualTo(expectedValue);


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
