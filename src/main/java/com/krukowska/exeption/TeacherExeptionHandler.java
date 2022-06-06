package com.krukowska.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class TeacherExeptionHandler {

    @ExceptionHandler(value = {TeacherException.class})
    public ResponseEntity<Object> handleApiRequestException(TeacherException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        TeacherExeption apiException = new TeacherExeption(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.systemDefault())
        );

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
