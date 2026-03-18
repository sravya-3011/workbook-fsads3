package com.klu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;
import com.klu.service.BookService;

@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public int count() {
        return 100;
    }

    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> books() {
        return Arrays.asList("Java Programming", "Spring Boot Guide", "Data Structures");
    }

    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching book with title: " + title;
    }

    @GetMapping("/author/{name}")
    public String authorName(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookService.getAllBooks();
    }
}