package com.example.logbackdemo.controller;

import com.example.logbackdemo.mapper.StudentMapper;
import com.example.logbackdemo.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuyk
 * @Description: 测试类
 * @Date: 2020/11/12
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/addStudent")
    public void addStudent(@RequestParam String name,
                           @RequestParam Boolean isError){
        if(isError){
            throw new RuntimeException("测试异常");
        }
        Student student = Student.builder()
                .name(name).build();
        studentMapper.insertSelective(student);
    }

}
