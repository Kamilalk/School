package com.krukowska.exception;

import org.springframework.http.HttpStatus;

public class StudentRequestException extends RuntimeException {

    private final HttpStatus status;

    public StudentRequestException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return this.status;
    }

}
