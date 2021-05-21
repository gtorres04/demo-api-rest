package com.test.demo.domain.exception;

public class BrandIdInvalidException extends RuntimeException{
    public BrandIdInvalidException() {
        super("ID de la Cadena del Grupo invalido");
    }
}
