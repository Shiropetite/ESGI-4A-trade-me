package com.archi.trademe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(ApplicationConfiguration.class)
@SpringBootApplication
public class TradeMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeMeApplication.class, args);
    }

}
