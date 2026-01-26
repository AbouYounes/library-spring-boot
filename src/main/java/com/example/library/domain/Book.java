package com.example.library.domain;

import com.example.library.exception.BookAlreadyBorrowedException;
import com.example.library.exception.BookNotBorrowedException;

/**
 * Domain model representing a Book inside the library.
 *
 * IMPORTANT:
 * - This is NOT an API DTO
 * - This represents business state
 * - It must NOT contain Spring annotations
 */

public class Book {

    private final String isbn;
    private final String title;
    private final String author;

    private boolean available = true;



    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void borrow(){
        if (!available){
            throw new BookAlreadyBorrowedException(isbn);
        }
        this.available = false;
    }

    public void returnBook(){
        if (available){
            throw new BookNotBorrowedException(isbn);
        }
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return available;
    }
}
