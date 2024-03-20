package com.example.springboot.API;

import com.example.springboot.Service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NameController {

    private final NameService nameService;

    @Autowired
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping("/addName")
    public ResponseEntity<String> addName(@RequestParam String firstName, @RequestParam String lastName) {
        return nameService.addName(firstName, lastName);
    }

    @GetMapping("/getLastName/{firstName}")
    public ResponseEntity<String> getLastName(@PathVariable String firstName) {
        return nameService.getLastName(firstName);
    }
}

