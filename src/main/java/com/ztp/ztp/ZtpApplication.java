package com.ztp.ztp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ZtpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZtpApplication.class, args);
    }
}
