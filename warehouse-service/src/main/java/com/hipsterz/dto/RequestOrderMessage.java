package com.hipsterz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class RequestOrderMessage {
    @JsonProperty("orderId")
    private UUID orderId;

    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("street")
    private String street;

    @JsonProperty("country")
    private String country;

    @JsonProperty("zipCode")
    private String zipcode;

    @JsonProperty("province")
    private String province;



    public RequestOrderMessage() {}

    public RequestOrderMessage(UUID orderId, OrderStatus orderStatus, String customerName, String street, String zipcode, String  province) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.customerName = customerName;
        this.street = street;
        this.zipcode = zipcode;
        this.province = province;

    }

    public RequestOrderMessage(UUID orderId, OrderStatus orderStatus, String customerName, String street, String zipcode, String province, String country) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.customerName = customerName;
        this.street = street;
        this.zipcode = zipcode;
        this.province = province;
        this.country = country;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getProvince() {
        return province;
    }

    public String getCustomerName() {
        return customerName;
    }
}

