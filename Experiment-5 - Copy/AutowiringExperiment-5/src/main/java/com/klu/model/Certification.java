package com.klu.model;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class Certification {
    private int id = 101;
    private String name = "Java Spring Boot";
    private LocalDate dateOfCompletion = LocalDate.of(2025, 3, 1);

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDateOfCompletion() { return dateOfCompletion; }

    @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfCompletion=" + dateOfCompletion +
                '}';
    }
}
