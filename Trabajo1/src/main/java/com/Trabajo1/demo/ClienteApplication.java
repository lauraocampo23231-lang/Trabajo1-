package com.Trabajo1.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
        System.out.println("🚀 Aplicación Cliente iniciada correctamente...");
    }
}
