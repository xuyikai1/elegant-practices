package org.elegant.practoces.mapstruct;

import org.elegant.practoces.domain.StudentBO;
import org.elegant.practoces.domain.StudentPO;
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
@Mapper(componentModel = "spring")
public interface StudentMapping {

    StudentMapping INSTANCE = Mappers.getMapper(StudentMapping.class);

    @Mappings({
            @Mapping(source = "name", target = "studentName")
    })
    StudentBO studentPO2StudentBO(StudentPO source);

    List<StudentBO> toConvertBOs(List<StudentPO> list);

}
