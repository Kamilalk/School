package com.krukowska.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class TeacherException {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timestamp;

    public TeacherException(String message, HttpStatus status, ZonedDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
}


