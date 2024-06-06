package com.hackathon.studentpoint.hackatonstudentpoint.Exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleExceptionEmptyResultDataAccessException(Exception e) {
        return new ResponseEntity<>("[EXCEPTION][ERROR INTERNO] " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleExceptionNullPointerException(Exception e) {
        return new ResponseEntity<>("[EXCEPTION][NO DATA] " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handleExceptionNoResourceFoundException(Exception e) {
        return new ResponseEntity<>("[EXCEPTION][NO DATA] " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
