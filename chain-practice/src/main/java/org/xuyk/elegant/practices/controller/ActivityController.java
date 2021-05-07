package org.xuyk.elegant.practices.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xuyk.elegant.practices.pojo.Activity;
import org.xuyk.elegant.practices.pojo.ActivityRequest;
import org.xuyk.elegant.practices.pojo.ResultDto;
import org.xuyk.elegant.practices.service.ActivityService;

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
