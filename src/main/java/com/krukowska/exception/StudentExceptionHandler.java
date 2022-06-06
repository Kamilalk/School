package com.krukowska.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(value = {StudentRequestException.class})
    public ResponseEntity<Object> handleStudentRequestException(StudentRequestException s){

        StudentException apiException = new StudentException(
                s.getMessage(),
                s.getStatus(),
                ZonedDateTime.now(ZoneId.systemDefault())
        );

        return new ResponseEntity<>(apiException, s.getStatus());
    }
}
