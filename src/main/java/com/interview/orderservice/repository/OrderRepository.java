package com.interview.orderservice.repository;
import com.interview.orderservice.model.OrderResponse;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderRepository extends MongoRepository <OrderResponse, String> {
}
