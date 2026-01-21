package com.example.library.service;

import com.example.library.domain.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryService {

    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book){
        if (books.containsKey(book.getIsbn())){
            throw new IllegalArgumentException("Duplicate ISBN");
        }
        books.put(book.getIsbn(), book);
    }

    public String healthCheck(){
        return "Library service is running";
    }
}
