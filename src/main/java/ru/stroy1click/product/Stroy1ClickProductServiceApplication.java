package ru.stroy1click.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Stroy1ClickProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Stroy1ClickProductServiceApplication.class, args);
    }

}
