package com.example.library.dto;


import com.example.library.domain.Book;

/**
 * API response DTO for Book.
 *
 * Purpose:
 * - Defines what the API exposes to clients
 * - Prevents leaking internal domain objects
 * - Keeps response structure stable
 */
public class BookResponse {

    private final String isbn;
    private final String title;
    private final String author;
    private final boolean available;

    private BookResponse(String isbn, String title, String author, boolean available){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public static BookResponse from(Book book){
        return new BookResponse(
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.isAvailable()
        );
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return  author;
    }

    public boolean isAvailable(){
        return available;
    }


}
