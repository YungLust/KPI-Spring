package org.example.lab1commandlineapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class First implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("First");
    }
}
