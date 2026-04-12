package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Spring Boot Backend!";
    }
}
