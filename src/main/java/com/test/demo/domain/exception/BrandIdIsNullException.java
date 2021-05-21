package com.test.demo.domain.exception;

public class BrandIdIsNullException extends RuntimeException{
    public BrandIdIsNullException() {
        super("ID de la Cadena del Grupo no puede ser null");
    }
}
