package com.example.mapstructdemo;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/16
 */
@Slf4j
public class MapStructTest {

    public static void main(String[] args) {
        StudentPO po = StudentPO.builder()
                .id("1").name("小明").age(12).build();
        StudentBO bo = StudentCovertBasic.INSTANCE.toConvertBO(po);
        log.info("【bo】:{}", JSONUtil.toJsonStr(bo));

        List<StudentPO> pos = new ArrayList<>();
        pos.add(po);
        List<StudentBO> bos = StudentCovertBasic.INSTANCE.toConvertBOs(pos);
        log.info("【bos】:{}",JSONUtil.toJsonStr(bos));
    }

}
