package com.kele.sharebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@EnableAutoConfiguration

@SpringBootApplication
public class SharebaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SharebaseApplication.class, args);
    }
}
