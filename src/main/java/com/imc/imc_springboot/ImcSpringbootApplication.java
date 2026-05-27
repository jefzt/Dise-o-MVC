package com.imc.imc_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.imc")
public class ImcSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImcSpringbootApplication.class, args);
    }
}