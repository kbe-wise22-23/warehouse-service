package com.hipsterz.warehouse.port;

import com.hipsterz.warehouse.port.admin.consumer.ShipmentChangeConsumer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

//@Component
public class ShipmentRunner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final ShipmentChangeConsumer cartConsumer;

    @Value("cart_exchange")
    private String exchange;

    @Value("cart_routing_key")
    private String routingKey;

    public ShipmentRunner(ShipmentChangeConsumer cartConsumer, RabbitTemplate rabbitTemplate) {
        this.cartConsumer = cartConsumer;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        this.rabbitTemplate.convertAndSend(exchange, routingKey, "beep boop much message");
    }
}
