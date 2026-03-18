package com.klu;

import com.klu.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AutowiringExperiment5Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AutowiringExperiment5Application.class, args);

        // Retrieve Student bean from Spring IoC container
        Student student = context.getBean(Student.class);

        // Print student and certification details
        System.out.println(student);
    }
}
