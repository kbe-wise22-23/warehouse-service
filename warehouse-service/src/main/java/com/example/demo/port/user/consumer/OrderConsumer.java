package com.example.demo.port.user.consumer;

import com.example.demo.core.domain.service.interfaces.IOrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductConsumer.class);

    @Autowired
    private IOrderService orderService;

    @RabbitListener(queues = { "order" })
    public void consume(String message) {

        LOGGER.info(String.format("Received message -> %s", message));
        orderService.getOrder(123);
    }
}