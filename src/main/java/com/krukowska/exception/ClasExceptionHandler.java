package com.krukowska.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ClasExceptionHandler {
    @ExceptionHandler(value = {ClasRequestException.class})
    public ResponseEntity<Object> handleClasRequestException(ClasRequestException s){

        ClasException apiException = new ClasException(
                s.getMessage(),
                s.getStatus(),
                ZonedDateTime.now(ZoneId.systemDefault())
        );

        return new ResponseEntity<>(apiException, s.getStatus());
    }
}
