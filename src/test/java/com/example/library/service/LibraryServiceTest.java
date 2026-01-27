package com.example.library.service;

import com.example.library.exception.BookAlreadyBorrowedException;
import com.example.library.exception.BookNotBorrowedException;
import com.example.library.exception.BookNotFoundException;
import com.example.library.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {

    private LibraryService libraryService;

    @BeforeEach
    void setUp(){
        libraryService = new LibraryService();
    }

    @Test
    void addBook_shouldStoreBook(){
        Book book = new Book("123", "Clean Code", "Robert Martin");

        libraryService.addBook(book);

        Book stored = libraryService.findBookByIsbn("123");
        assertEquals("Clean Code", stored.getTitle());
    }

    @Test
    void finBookByIsbn_shouldThrow_whenNotFound(){
        assertThrows(
            BookNotFoundException.class,
                () -> libraryService.findBookByIsbn("999")
        );
    }

    @Test
    void borrowBook_shouldMarkBookAsUnavailable(){
        Book book = new Book("123", "Clean Code", "Robert Martin");
        libraryService.addBook(book);

        libraryService.borrowBook("123");

        assertFalse(
                libraryService.findBookByIsbn("123").isAvailable()
        );
    }

    @Test
    void borrowBook_shouldThrow_whenAlreadyBorrowed(){
        Book book = new Book("123", "Clean Code", "Robert Martin");
        libraryService.addBook(book);
        libraryService.borrowBook("123");

        assertThrows(
                BookAlreadyBorrowedException.class,
                () -> libraryService.borrowBook("123")
        );
    }

    @Test
    void returnBook_shouldMarkBookAsAvailable(){
        Book book = new Book("123", "Clean Code", "Robert Martin");
        libraryService.addBook(book);

        libraryService.borrowBook("123");
        libraryService.returnBook("123");

        assertTrue(
                libraryService.findBookByIsbn("123").isAvailable()
        );
    }

    @Test
    void returnBook_shouldThrow_whenNotBorrowed(){
        Book book = new Book("123", "Clean Code", "Robert Martin");
        libraryService.addBook(book);

        assertThrows(
                BookNotBorrowedException.class,
                () -> libraryService.returnBook("123")
        );
    }
}
