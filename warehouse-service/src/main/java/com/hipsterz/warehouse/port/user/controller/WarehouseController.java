package com.hipsterz.warehouse.port.user.controller;

import com.hipsterz.warehouse.core.domain.service.interfaces.IShipmentService;

import com.hipsterz.warehouse.port.user.exception.OrderNotFoundException;


import com.hipsterz.warehouse.core.domain.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class WarehouseController {

    @Autowired
    private IShipmentService shipmentService;

    @PostMapping(path = "/shipment")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void createShipment(@RequestBody Shipment shipment) {
        shipmentService.createShipment(shipment);
    }

    @GetMapping("/shipment/{id}")
    public Shipment getShipment(@PathVariable UUID id) {
        Shipment shipment  = shipmentService.getOrder(id);

        if (shipment == null) {
            throw new OrderNotFoundException();
        }

        return shipment;
    }

    @PutMapping(path = "/shipment")
    public @ResponseBody String update(Shipment shipment) {
        shipmentService.updateShipment(shipment);
        return "Updated : " + shipment.getId();
    }

    @DeleteMapping(path = "/shipment")
    public @ResponseBody String delete( int id) {
     return null;

    }

    @GetMapping("/shipment")
    public @ResponseBody Iterable<Shipment> getShipments() {
        return shipmentService.getAllShipments();
    }

}
