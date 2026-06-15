package com.example.flipflop.creditcard.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Crucial: Enables OpenFeign declaration processing across the application
public class FlipFlopCreditCardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlipFlopCreditCardServiceApplication.class, args);
    }
}