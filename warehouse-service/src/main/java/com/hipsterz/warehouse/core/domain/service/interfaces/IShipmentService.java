package com.hipsterz.warehouse.core.domain.service.interfaces;

import com.hipsterz.warehouse.core.domain.model.Shipment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IShipmentService {
    void createShipment(Shipment shipment);

    void updateShipment(Shipment shipment);

    void deleteShipment(Shipment shipment);

    Shipment getOrder(UUID id);


    Iterable<Shipment> getAllShipments();
}