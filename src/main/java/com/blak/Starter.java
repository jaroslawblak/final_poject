package com.blak;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:springconfig.xml")
public class Starter {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Starter.class, args);

    }
}
