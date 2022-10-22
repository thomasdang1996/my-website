package com.dang.mywebsite.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
 //   @Bean
    CommandLineRunner commandLineRunner(IStudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@example.com",
                    LocalDate.of(2000, Month.APRIL, 5));
            Student alex = new Student(
                    "Alex",
                    "alex@example.com",
                    LocalDate.of(2000, Month.APRIL, 5)
            );
            repository.saveAll(List.of(mariam, alex));
        };
    }
}
