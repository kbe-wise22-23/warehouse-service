package com.example.demo.port.user.controller;

import com.example.demo.core.domain.service.interfaces.IOrderService;

import com.example.demo.port.user.exception.OrderNotFoundException;

import jakarta.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping(path = "/order")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = orderService.getOrder(id);

        if (order == null) {
            throw new OrderNotFoundException();
        }

        return order;
    }

    @PutMapping(path = "/order")
    public @ResponseBody String update() {

        return null;
    }

    @DeleteMapping(path = "/order")
    public @ResponseBody String delete() {

        return null;
    }

    @GetMapping("/orders")
    public @ResponseBody Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

}
