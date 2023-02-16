package com.example.demo.core.domain.service.interfaces;

import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    void createOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);

    Order getOrder(int id);

    Iterable<Order> getAllOrders();
}