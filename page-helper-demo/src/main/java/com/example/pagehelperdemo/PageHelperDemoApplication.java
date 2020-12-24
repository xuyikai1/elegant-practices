package com.example.pagehelperdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.**.mapper",markerInterface = MyMapper.class)
@EnableDiscoveryClient
@SpringBootApplication
public class PageHelperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageHelperDemoApplication.class, args);
    }

}
