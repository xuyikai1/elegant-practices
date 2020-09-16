package com.example.chaindemo.service;

import com.example.chaindemo.pojo.Activity;
import com.example.chaindemo.pojo.ActivityRequest;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/9/16
 */
public interface ActivityService {

    /**
     * 创建活动
     * @param request
     * @return
     */
    Activity create(ActivityRequest request);

}
