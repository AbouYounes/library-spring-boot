package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.exception.DuplicateIsbnException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryService {

    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book){
        if (books.containsKey(book.getIsbn())){
            throw new DuplicateIsbnException(book.getIsbn());
        }
        books.put(book.getIsbn(), book);
    }

    public String healthCheck(){
        return "Library service is running";
    }
}
