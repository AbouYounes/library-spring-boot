package com.example.library.controller;

import com.example.library.dto.ErrorResponse;
import com.example.library.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBookNotFound(BookNotFoundException ex){
        return new ErrorResponse(
                "BOOK_NOT_FOUND",
                ex.getMessage()
        );
    }

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return new ErrorResponse(
                "VALIDATION_ERROR",
                message
        );
    }

    @ExceptionHandler(BookAlreadyBorrowedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleBookAlreadyBorrowed(BookAlreadyBorrowedException ex){
        return new ErrorResponse("Book_ALREADY_BORROWED", ex.getMessage());
    }

    @ExceptionHandler(BookNotBorrowedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleBookNotBorrowed(BookNotBorrowedException ex){
        return new ErrorResponse("BOOK_NOT_BORROWED", ex.getMessage());
    }
}
