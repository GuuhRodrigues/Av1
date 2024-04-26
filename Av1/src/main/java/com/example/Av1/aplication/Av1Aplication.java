package com.example.Av1.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.Av1.repository")
public class Av1Aplication {
    public static void main(String[] args) {
        SpringApplication.run(Av1Aplication.class, args);
    }
}
