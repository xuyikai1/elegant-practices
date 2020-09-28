package com.imooc.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 半仙.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        // 通过SpringApplicationBuilder的方式构造启动类
        new SpringApplicationBuilder(EurekaServerApplication.class)
                // 定义启动方式 servlet
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
