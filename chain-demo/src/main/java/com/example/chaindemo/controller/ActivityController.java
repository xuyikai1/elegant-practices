package com.example.chaindemo.controller;

import com.example.chaindemo.pojo.Activity;
import com.example.chaindemo.pojo.ActivityRequest;
import com.example.chaindemo.pojo.ResultDto;
import com.example.chaindemo.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/9/16
 */
@RestController
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/activity/create")
    public ResultDto<Activity> create(@RequestBody ActivityRequest request){
        // 省略分布式锁
        return ResultDto.ok(activityService.create(request));
    }

}
