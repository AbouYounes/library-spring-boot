package com.example.library.controller;

import com.example.library.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/health")
    public String health(){
        return libraryService.healthCheck();
    }
}
