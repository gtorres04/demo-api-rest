package com.test.demo.domain.exception;

public class ProductIdInvalidException extends RuntimeException{
    public ProductIdInvalidException() {
        super("IdD del Producto invalido");
    }
}
