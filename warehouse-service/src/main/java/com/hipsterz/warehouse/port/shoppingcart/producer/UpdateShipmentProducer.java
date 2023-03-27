package com.hipsterz.warehouse.port.shoppingcart.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UpdateShipmentProducer {

    @Value("shipment_update")
    private String exchange;

    @Value("shipment_routing_key")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateShipmentProducer.class);

    private RabbitTemplate rabbitTemplate = new RabbitTemplate();



    public void UpdateShipmentProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;

    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}