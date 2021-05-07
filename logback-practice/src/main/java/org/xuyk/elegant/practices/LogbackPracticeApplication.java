package org.xuyk.elegant.practices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.**.mapper",markerInterface = org.xuyk.elegant.practices.MyMapper.class)
@SpringBootApplication
public class LogbackPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbackPracticeApplication.class, args);
    }

}
