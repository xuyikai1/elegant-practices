package com.example.logbackdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.**.mapper",markerInterface = MyMapper.class)
@SpringBootApplication
public class LogbackDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbackDemoApplication.class, args);
    }

}
