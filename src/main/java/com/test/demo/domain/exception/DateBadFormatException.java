package com.test.demo.domain.exception;

public class DateBadFormatException extends RuntimeException{
    public DateBadFormatException() {
        super("Formato de la fecha invalido");
    }
}
