package com.krukowska.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleClasRequestException(RequestException s){

        Exception apiException = new Exception(
                s.getMessage(),
                s.getStatus(),
                ZonedDateTime.now(ZoneId.systemDefault())
        );

        return new ResponseEntity<>(apiException, s.getStatus());
    }
}
