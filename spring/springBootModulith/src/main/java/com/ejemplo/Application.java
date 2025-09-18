package com.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;
import org.springframework.scheduling.annotation.EnableAsync;

@Modulithic(
    systemName = "Spring Modulith Demo",
    sharedModules = {"shared"}
)
@SpringBootApplication
@EnableAsync
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}