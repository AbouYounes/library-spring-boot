package com.example.library.domain;

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

    private boolean available;



    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
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
