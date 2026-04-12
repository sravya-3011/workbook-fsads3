
package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @PostMapping
    public Student create(@RequestBody Student s) { return service.save(s); }

    @GetMapping
    public List<Student> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}
