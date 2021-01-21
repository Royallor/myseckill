package com.adder.myseckillback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.adder.myseckillback.dao")
@SpringBootApplication
public class MyseckillBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyseckillBackApplication.class, args);
    }

}
