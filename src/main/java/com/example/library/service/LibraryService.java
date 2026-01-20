package com.example.library.service;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    public String healthCheck(){
        return "Library service is running";
    }
}
