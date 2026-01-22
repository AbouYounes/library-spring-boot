package com.example.library.controller;

import com.example.library.dto.ErrorResponse;
import com.example.library.exception.DuplicateIsbnException;
import com.example.library.exception.MissingIsbnException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateIsbnException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleDuplicateIsbn(DuplicateIsbnException ex){
        return new ErrorResponse(
                "DUPLICATE_ISBN",
                ex.getMessage()
        );
    }

    @ExceptionHandler(MissingIsbnException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse HandleMissingIsbn(MissingIsbnException ex){
        return new ErrorResponse(
                "MISSING ISBN",
                ex.getMessage()
        );
    }
}
