package com.hipsterz.warehouse.core.domain.service.interfaces;

import com.hipsterz.warehouse.core.domain.model.Shipment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IShipmentRepository extends CrudRepository<Shipment, UUID> {

}