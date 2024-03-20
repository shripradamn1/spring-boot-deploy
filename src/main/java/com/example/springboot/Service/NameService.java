package com.example.springboot.Service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NameService implements INameService {

    private final Map<String, String> nameMap = new HashMap<>();

    @Override
    public ResponseEntity<String> addName(String firstName, String lastName) {
        if (firstName.contains(" ")) {
            return new ResponseEntity<>("Bad Request: First name cannot contain a space.", HttpStatus.BAD_REQUEST);
        }
        nameMap.put(firstName, lastName);
        return new ResponseEntity<>("Name added successfully.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getLastName(String firstName) {
        if (firstName.contains(" ")) {
            return new ResponseEntity<>("Bad Request: First name cannot contain a space.", HttpStatus.BAD_REQUEST);
        }

        String lastName = nameMap.get(firstName);
        if (lastName == null) {
            return new ResponseEntity<>("Not Found: Last name not found for the given first name.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lastName, HttpStatus.OK);
    }
}


