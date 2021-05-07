package org.elegant.practoces.test;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.elegant.practoces.domain.StudentBO;
import org.elegant.practoces.mapstruct.StudentMapping;
import org.elegant.practoces.domain.StudentPO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xuyk
 * @Description: 使用方式一
 * @Date: 2020/11/16
 */
@Slf4j
public class MapStructTest {

    public static void main(String[] args) {
        StudentPO po = StudentPO.builder()
                .id("1").name("小明").age(12).build();
        StudentBO bo = StudentMapping.INSTANCE.studentPO2StudentBO(po);
        log.info("【bo】:{}", JSONUtil.toJsonStr(bo));

        List<StudentPO> pos = new ArrayList<>();
        pos.add(po);
        List<StudentBO> bos = StudentMapping.INSTANCE.toConvertBOs(pos);
        log.info("【bos】:{}",JSONUtil.toJsonStr(bos));
    }

}
