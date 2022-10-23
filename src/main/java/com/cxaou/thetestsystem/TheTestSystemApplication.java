package com.cxaou.thetestsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cxaou.thetestsystem.mapper")
@SpringBootApplication
public class TheTestSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheTestSystemApplication.class, args);
    }

}
