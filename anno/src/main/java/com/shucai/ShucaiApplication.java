package com.shucai;

import com.shucai.registrar.EnableOperator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableOperator
public class ShucaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShucaiApplication.class, args);
    }
}
