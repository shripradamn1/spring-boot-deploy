package com.example.springboot.Service;

import org.springframework.http.ResponseEntity;

public interface INameService {
    ResponseEntity<String> addName(String firstName, String lastName);
    ResponseEntity<String> getLastName(String firstName);
}

