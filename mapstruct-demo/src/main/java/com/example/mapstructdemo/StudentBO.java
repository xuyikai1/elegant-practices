package com.example.mapstructdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyk
 * @Description: 实体逻辑类 除了数据表字段还包含其他字段
 * @Date: 2020/11/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentBO {

    private String id;

    /**
     * 模拟日常工作下 两个类字段不一致的情况
     * name <-> studentName
     */
    private String studentName;

    private Integer age;

}
