package com.krukowska.exeption;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class TeacherExeption {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public TeacherExeption(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
