package com.example.library.exception;

public class BookNotBorrowedException extends RuntimeException{
    public BookNotBorrowedException(String isbn){
        super("Book with ISBN " + isbn + " is not borrowed");
    }
}
