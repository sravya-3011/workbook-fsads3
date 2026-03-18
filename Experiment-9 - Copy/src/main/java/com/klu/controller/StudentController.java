package com.klu.controller;

import com.klu.exception.*;
import com.klu.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        if(id <= 0){
            throw new InvalidInputException("Student ID must be positive");
        }

        if(id != 101){
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return new Student(101, "Harika", "CSE");
    }
}