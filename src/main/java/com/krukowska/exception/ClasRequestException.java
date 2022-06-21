package com.krukowska.exception;

import org.springframework.http.HttpStatus;

public class ClasRequestException extends RuntimeException {
    private final HttpStatus status;

    public ClasRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
