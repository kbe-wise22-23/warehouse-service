package com.hipsterz.warehouse.port.admin.consumer;

import com.hipsterz.warehouse.core.domain.model.Shipment;
import com.hipsterz.warehouse.core.domain.service.interfaces.IShipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentChangeConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShipmentChangeConsumer.class);
    @Autowired
    private IShipmentService shipmentService;

    @RabbitListener(queues = {"shipment"})
    public void consume(String message) {

        Shipment p = new Shipment();
        shipmentService.createShipment(p);

        LOGGER.info(String.format("Shipment created: %s", p.getId()));
    }
}