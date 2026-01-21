package com.example.library.exception;

/**
 * Thrown when a required ISBN value is missing or blank.
 */
public class MissingIsbnException extends RuntimeException{

    public  MissingIsbnException(){
        super("ISBN is required");
    }
}
