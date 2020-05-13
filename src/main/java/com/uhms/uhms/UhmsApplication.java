package com.uhms.uhms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UhmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UhmsApplication.class, args);
    }

}
