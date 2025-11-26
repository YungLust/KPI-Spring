package org.example.lab1commandlineapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Order(1)
public class Lab1CommandLineApplication implements CommandLineRunner {


    public static void main(String[] args) {
        System.out.println("Greetings from main!");
        SpringApplication.run(Lab1CommandLineApplication.class, args);
        System.out.println("Bye-Bye from main!");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, running the application!");

    }
}

