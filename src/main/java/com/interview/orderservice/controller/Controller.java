package com.interview.orderservice.controller;

import com.interview.orderservice.impl.SubmitOrderImpl;
import com.interview.orderservice.model.OrderRequest;
import com.interview.orderservice.model.OrderResponse;
import com.interview.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class Controller {
    @Autowired
    SubmitOrderImpl submitOrderImpl;
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<OrderResponse> submitOrder(@RequestBody OrderRequest orderRequest) {
        try {
            return new ResponseEntity<OrderResponse>(orderRepository.save(submitOrderImpl.submitOrder(orderRequest)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrderInfo/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") String id) {
        Optional<OrderResponse> orderInfo = orderRepository.findById(id);

        if (orderInfo.isPresent()) {
            return new ResponseEntity<>(orderInfo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        try {
            List<OrderResponse> orders = new ArrayList<>(orderRepository.findAll());
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
