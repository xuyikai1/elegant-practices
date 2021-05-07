package org.xuyk.elegant.practices.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xuyk.elegant.practices.mapper.StudentMapper;
import org.xuyk.elegant.practices.pojo.Student;

/**
 * @Author: Xuyk
 * @Description: 测试类
 * @Date: 2020/11/12
 */
@Slf4j
@RestController
public class TestController {

    private final StudentMapper studentMapper;

    public TestController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

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
