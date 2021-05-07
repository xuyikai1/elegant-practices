package org.xuyk.elegant.practices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.**.mapper", markerInterface = MyMapper.class)
@SpringBootApplication
public class AopPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopPracticeApplication.class, args);
    }

}
