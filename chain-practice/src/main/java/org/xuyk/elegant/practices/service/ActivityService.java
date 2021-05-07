package org.xuyk.elegant.practices.service;


import org.xuyk.elegant.practices.pojo.Activity;
import org.xuyk.elegant.practices.pojo.ActivityRequest;

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
