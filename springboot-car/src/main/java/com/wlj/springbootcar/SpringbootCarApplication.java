package com.wlj.springbootcar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.wlj.springbootcar.dao")
@SpringBootApplication
public class SpringbootCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCarApplication.class, args);
    }

}
