package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRespository){
        return args -> {
            Student mariam = new Student(
                "Mariam",
                "mariam.jamel@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 29),
                    25
            );
            Student alex = new Student(
                    "Alex",
                    "alex.jamel@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 29),
                    21
            );


        };
    }
}
