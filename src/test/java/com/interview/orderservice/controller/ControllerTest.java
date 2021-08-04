package com.interview.orderservice.controller;

import com.interview.orderservice.impl.SubmitOrderImpl;
import com.interview.orderservice.impl.SubmitOrderImplTest;
import com.interview.orderservice.model.OrderRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @InjectMocks
    Controller orderContoller;

    @Mock
    SubmitOrderImpl submitOrder;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void submitOrder() throws Exception {
        //Given
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setApples(1);
        orderRequest.setOranges(2);

        //When
        orderContoller.submitOrder(orderRequest);

        //Then
        verify(submitOrder, times(1)).submitOrder(orderRequest);




    }


}
