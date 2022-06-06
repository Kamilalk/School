package com.krukowska.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class TeacherExceptionHandler {

    @ExceptionHandler(value = {TeacherRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(TeacherRequestException t){

        TeacherException apiException = new TeacherException(
                t.getMessage(),
                t.getStatus(),
                ZonedDateTime.now(ZoneId.systemDefault())
        );

        return new ResponseEntity<>(apiException, t.getStatus());
    }
}
