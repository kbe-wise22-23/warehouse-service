package com.hipsterz.warehouse.port.config;

/*
@Configuration
public class RabbitMQConfig {

    @Value("shipment")
    private String shipmentQueue;

    @Value("item")
    private String itemQueue;

    @Value("shipment_exchange")
    private String exchange;

    @Value("shipment_routing_key")
    private String routingKey;

    @Value("item_routing_key")
    private String itemRoutingKey;

    @Bean
    public Queue shipmentQueue() {
        return new Queue(shipmentQueue);
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
                .bind(shipmentQueue())
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


 */