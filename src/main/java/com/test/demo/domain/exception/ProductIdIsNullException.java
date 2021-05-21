package com.test.demo.domain.exception;

public class ProductIdIsNullException extends RuntimeException{
    public ProductIdIsNullException() {
        super("ID del producto no puede ser null");
    }
}
