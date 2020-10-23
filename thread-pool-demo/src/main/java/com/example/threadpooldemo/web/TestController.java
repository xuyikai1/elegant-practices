package com.example.threadpooldemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/10/20
 */
@RestController
public class TestController {

    @Autowired
    private ExecutorService executor;

    @GetMapping("/threadPool")
    public void threadPoolTest(@RequestParam("count") Integer count){
        for (int i=0 ; i<count ; i++){
            executor.submit(() ->
                    System.out.println("CurrentThread name:"
                            + Thread.currentThread().getName()));

        }
    }

}
