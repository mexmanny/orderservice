package com.interview.orderservice.controller;

import com.interview.orderservice.impl.SubmitOrderImpl;
import com.interview.orderservice.model.OrderRequest;
import com.interview.orderservice.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
public class Controller {
    @Autowired
    SubmitOrderImpl submitOrderImpl;
    @RequestMapping(value = "/submit", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<OrderResponse> submitOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<OrderResponse>(submitOrderImpl.submitOrder(orderRequest), HttpStatus.CREATED);
    }
}
