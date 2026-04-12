
package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo) { this.repo = repo; }

    public Student save(Student s) { return repo.save(s); }
    public List<Student> getAll() { return repo.findAll(); }
    public Student getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }
    public Student update(Long id, Student s) {
        Student old = getById(id);
        old.setName(s.getName());
        old.setEmail(s.getEmail());
        old.setCourse(s.getCourse());
        return repo.save(old);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
