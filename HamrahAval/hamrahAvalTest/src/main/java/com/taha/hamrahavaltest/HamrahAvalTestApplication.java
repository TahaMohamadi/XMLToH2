package com.taha.hamrahavaltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HamrahAvalTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HamrahAvalTestApplication.class, args);
    }

}
