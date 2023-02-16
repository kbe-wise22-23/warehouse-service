package com.example.demo.port.shoppingcart.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderProducer {

    @Value("order_update")
    private String exchange;

    @Value("order_routing_key")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateOrderProducer.class);

    private RabbitTemplate rabbitTemplate = new RabbitTemplate();

    public void UpdateProdcutProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;

    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}