package com.hipsterz.warehouse.port.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitMQConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Value("update_order")
    private String requestQueue;

    @Value("payment")
    private String paymentExchange;

    @Bean
    public Queue requestQueue() {
        return new Queue(requestQueue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(paymentExchange);
    }

    @Bean
    public Binding paymentExchangeRequestQueueBinding() {
        return BindingBuilder
                .bind(requestQueue())
                .to(exchange())
                .with("update.order");
    }
}

