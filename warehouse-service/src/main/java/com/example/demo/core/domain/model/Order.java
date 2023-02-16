package com.example.demo.core.domain.model;
//package com.postgresql.orders.model;

import jakarta.persistence.*;
import lombok.Data;

enum OrderStatus {
    NEW,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}

@Data
@Entity
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private OrderStatus orderStatus;
    private String customerName;
    private String street;
    private String country;
    private String zipcode;
    private String province;

    public Order() {
    }

    public Order(int id, OrderStatus orderStatus, String customerName, String street, String country, String zipcode,
            String province) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.customerName = customerName;
        this.street = street;
        this.country = country;
        this.zipcode = zipcode;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
}