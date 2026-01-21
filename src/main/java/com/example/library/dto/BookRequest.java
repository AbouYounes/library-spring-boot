package com.example.library.dto;

public class BookRequest {

     private String isbn;
     private String title;
     private String author;

     public BookRequest(){
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
}
