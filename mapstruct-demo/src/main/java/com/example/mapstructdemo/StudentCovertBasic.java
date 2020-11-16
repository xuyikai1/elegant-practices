package com.example.mapstructdemo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: Xuyk
 * @Description: 转换类
 * @Date: 2020/11/16
 */
@Mapper
public interface StudentCovertBasic {

    StudentCovertBasic INSTANCE = Mappers.getMapper(StudentCovertBasic.class);

    @Mappings({
            @Mapping(source = "name", target = "studentName")
    })
    StudentBO toConvertBO(StudentPO source);

    List<StudentBO> toConvertBOs(List<StudentPO> list);

}
