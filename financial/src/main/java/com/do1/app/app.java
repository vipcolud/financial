package com.do1.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * 管理端启动类
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.do1.entity"})
public class app{
    public static void main(String[] args) {
        SpringApplication.run(app.class);
       
    }
}

