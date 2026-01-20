package com.example.library.controller;

import com.example.library.dto.HealthResponse;
import com.example.library.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
