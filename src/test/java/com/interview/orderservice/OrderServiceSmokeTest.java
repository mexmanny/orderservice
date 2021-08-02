package com.interview.orderservice;

import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.interview.orderservice.controller.Controller;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderServiceSmokeTest {
    @Autowired
    private Controller orderServiceController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(orderServiceController).isNotNull();
    }


}
