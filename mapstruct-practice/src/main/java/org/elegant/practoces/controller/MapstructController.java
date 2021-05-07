package org.elegant.practoces.controller;

import lombok.extern.slf4j.Slf4j;
import org.elegant.practoces.mapstruct.StudentMapping;
import org.elegant.practoces.domain.StudentBO;
import org.elegant.practoces.domain.StudentPO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuyk
 * @description 使用方式二 更优雅
 * @date 2021-05-07
 */
@Slf4j
@RestController
public class MapstructController {

    @Resource
    private StudentMapping studentMapping;

    @GetMapping("/test")
    public StudentBO test(){
        StudentPO po = StudentPO.builder()
                .id("1").name("小明").age(12).build();
        return studentMapping.studentPO2StudentBO(po);
    }

}
