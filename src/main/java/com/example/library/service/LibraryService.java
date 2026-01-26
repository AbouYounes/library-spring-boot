package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.DuplicateIsbnException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryService {

    private final Map<String, Book> books = new HashMap<>();

    /**
     * Adds a new book to the library.
     *
     * @param book the book to add
     * @throws DuplicateIsbnException if a book with the same ISBN already exists
     */
    public void addBook(Book book){
        if (books.containsKey(book.getIsbn())){
            throw new DuplicateIsbnException(book.getIsbn());
        }
        books.put(book.getIsbn(), book);
    }

    /**
     * Returns all books in the library.
     *
     * @return collection of books
     */
    public Collection<Book> getAllBooks(){
        return books.values();
    }

    /**
     * Finds a book by its ISBN.
     *
     * @param isbn the ISBN to search for
     * @return the found book
     * @throws BookNotFoundException if no book exists with the given ISBN
     */
    public Book findBookByIsbn(String isbn){
        Book book = books.get(isbn);
        if (book == null){
            throw new BookNotFoundException(isbn);
        }
        return book;
    }

    public String healthCheck(){
        return "Library service is running";
    }
}
