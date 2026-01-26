package com.example.library.exception;

public class BookAlreadyBorrowedException extends RuntimeException{
    public BookAlreadyBorrowedException(String isbn){
        super("Book with ISBN " + isbn + " is already borrowed");
    }
}
