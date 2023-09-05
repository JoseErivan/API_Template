package com.api.exceptions.hanclers;

import com.api.exceptions.GenericException;
import com.api.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> exceptionResourceNotFoundHandler
            (ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        GenericException genericException = new GenericException(new Date(),
                resourceNotFoundException.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(genericException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericExceptionHandler
            (Exception exception, WebRequest webRequest) {
        GenericException genericException = new GenericException(new Date(),
                exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
