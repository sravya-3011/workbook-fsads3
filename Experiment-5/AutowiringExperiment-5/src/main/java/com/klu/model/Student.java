package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private int id = 1;
    private String name = "Sravyanjali";
    private String gender = "Female";

    @Autowired
    private Certification certification; // Autowiring Certification

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public Certification getCertification() { return certification; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", certification=" + certification +
                '}';
    }
}
