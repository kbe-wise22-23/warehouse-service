package com.example.demo.port.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("order")
    private String orderQueue;

    @Value("item")
    private String itemQueue;

    @Value("order_exchange")
    private String exchange;

    @Value("order_routing_key")
    private String routingKey;

    @Value("item_routing_key")
    private String itemRoutingKey;

    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueue);
    }

    @Bean
    public Queue itemQueue() {
        return new Queue(itemQueue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(orderQueue())
                .to(exchange())
                .with(routingKey);
    }

    @Bean
    public Binding itemBinding() {
        return BindingBuilder
                .bind(itemQueue())
                .to(exchange())
                .with(itemRoutingKey);
    }

}