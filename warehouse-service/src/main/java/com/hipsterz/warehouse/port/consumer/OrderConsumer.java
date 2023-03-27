package com.hipsterz.warehouse.port.consumer;

import com.hipsterz.dto.RequestOrderMessage;
import com.hipsterz.warehouse.core.domain.model.Shipment;
import com.hipsterz.warehouse.core.domain.model.ShipmentStatus;
import com.hipsterz.warehouse.core.domain.service.interfaces.IShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {
    @Autowired
    private IShipmentService shipmentService;

    @RabbitListener(queues = {"update_order"})
    public void consumer(RequestOrderMessage requestOrderMessage) {
        log.info(String.format("Incoming Message --> %s", requestOrderMessage));
        Shipment s = new Shipment();
        s.setId(requestOrderMessage.getOrderId());
        s.setCountry(requestOrderMessage.getCountry());
        s.setCustomerName(requestOrderMessage.getCustomerName());
        s.setProvince(requestOrderMessage.getProvince());
        s.setStreet( requestOrderMessage.getStreet());
        s.setShipmentStatus(ShipmentStatus.PROCESSING);

        shipmentService.createShipment(s);
    }
}
