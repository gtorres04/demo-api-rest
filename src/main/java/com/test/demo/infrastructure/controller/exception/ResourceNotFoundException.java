package com.test.demo.infrastructure.controller.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Recurso no encontrado");
    }
}
