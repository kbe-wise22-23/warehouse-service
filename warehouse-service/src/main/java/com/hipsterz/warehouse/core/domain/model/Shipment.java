package com.hipsterz.warehouse.core.domain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity

public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private ShipmentStatus shipmentStatus;
    private String customerName;
    private String street;
    private String country;
    private String zipcode;
    private String province;

    public Shipment() {
    }

    public Shipment(UUID id, ShipmentStatus shipmentStatus, String customerName, String street, String country, String zipcode,
                 String province) {
        this.id = id;
        this.shipmentStatus = shipmentStatus;
        this.customerName = customerName;
        this.street = street;
        this.country = country;
        this.zipcode = zipcode;
        this.province = province;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ShipmentStatus getOrderStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void updateShipment(Shipment shipment){
        if (this.id == shipment.getId()){
            this.country = shipment.country;
            this.shipmentStatus = shipment.shipmentStatus;
            this.customerName = shipment.customerName;
            this.street = shipment.street;
            this.province = shipment.province;
            this.zipcode = shipment.zipcode;
        }
    }
}