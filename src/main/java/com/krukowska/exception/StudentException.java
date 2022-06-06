package com.krukowska.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class StudentException {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timeStamp;

    public StudentException(String message, HttpStatus status, ZonedDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }
}
