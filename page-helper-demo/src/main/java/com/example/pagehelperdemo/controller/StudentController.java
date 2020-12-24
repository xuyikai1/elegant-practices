package com.example.pagehelperdemo.controller;

import com.example.pagehelperdemo.mapper.StudentMapper;
import com.example.pagehelperdemo.pojo.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/13
 */
@Slf4j
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/students")
    public List<Student> students(@RequestParam Integer pageNo,
                                  @RequestParam Integer pageSize){
        Page<Student> page = PageHelper.startPage(pageNo, pageSize);
        studentMapper.selectAll();
        log.debug("debug log");
        log.info("info log");
        return page.getResult();
    }

}
