package com.hipsterz.warehouse.port.user.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(int id) {
      super("Could not find product " +id);
    }
}
