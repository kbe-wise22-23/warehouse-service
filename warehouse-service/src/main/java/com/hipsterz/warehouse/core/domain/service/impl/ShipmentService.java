package com.hipsterz.warehouse.core.domain.service.impl;

import com.hipsterz.warehouse.core.domain.service.interfaces.IShipmentRepository;
import com.hipsterz.warehouse.core.domain.service.interfaces.IShipmentService;
import com.hipsterz.warehouse.core.domain.model.Shipment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShipmentService implements IShipmentService {

    private final IShipmentRepository shipmentRepository;

    public ShipmentService(IShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public void createShipment(Shipment shipment) {

        shipmentRepository.save(shipment);
    }

    @Override
    public void updateShipment(Shipment shipment) {
        shipmentRepository.save(shipment);
    }

    @Override
    public void deleteShipment(Shipment shipment) {
        shipmentRepository.delete(shipment);
    }

    @Override
    public Shipment getOrder(UUID id) {
        return shipmentRepository.findById(id).get();
    }

    @Override
    public Iterable<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
}
