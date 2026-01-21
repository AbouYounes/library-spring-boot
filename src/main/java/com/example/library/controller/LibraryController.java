package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.dto.BookRequest;
import com.example.library.dto.HealthResponse;
import com.example.library.exception.MissingIsbnException;
import com.example.library.service.LibraryService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/health")
    public HealthResponse health(){
        return new HealthResponse("Library API is running");
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BookRequest request){
        if (request.getIsbn() == null || request.getIsbn().isBlank()) {
            throw new MissingIsbnException();
        }
            Book book = new Book(
                request.getIsbn(),
                request.getTitle(),
                request.getAuthor()
        );
        libraryService.addBook(book);
    }
}
