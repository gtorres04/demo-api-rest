package com.test.demo.infrastructure.controller.exception.advice;

import com.test.demo.domain.exception.BrandIdInvalidException;
import com.test.demo.domain.exception.BrandIdIsNullException;
import com.test.demo.domain.exception.DateBadFormatException;
import com.test.demo.domain.exception.ProductIdInvalidException;
import com.test.demo.domain.exception.ProductIdIsNullException;
import com.test.demo.infrastructure.controller.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.test.demo.infrastructure.controller.api.model.ErrorDto;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Error no controlado: {}", ex.getLocalizedMessage());
        ErrorDto errorResponse = new ErrorDto();
        errorResponse.code(ex.getClass().getSimpleName());
        errorResponse.setMessage(ex.getMessage());
        log.error("Error no controlado, se responde: {}", errorResponse);
        return ResponseEntity.status(500).body(errorResponse);
    }

    @ExceptionHandler({ResourceNotFoundException.class, BrandIdIsNullException.class, BrandIdInvalidException.class, ProductIdIsNullException.class, ProductIdInvalidException.class})
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(RuntimeException runtimeException) {
        ErrorDto errorResponse = new ErrorDto();
        errorResponse.code(runtimeException.getClass().getSimpleName());
        errorResponse.setMessage(runtimeException.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(DateBadFormatException.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(DateBadFormatException runtimeException) {
        ErrorDto errorResponse = new ErrorDto();
        errorResponse.code(runtimeException.getClass().getSimpleName());
        errorResponse.setMessage(runtimeException.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }
}
