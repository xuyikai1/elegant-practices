package org.xuyk.elegant.practices.service.impl;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xuyk.elegant.practices.filter.ActivityFilterChain;
import org.xuyk.elegant.practices.filter.ActivityInfoFilter;
import org.xuyk.elegant.practices.filter.ActivityUserFilter;
import org.xuyk.elegant.practices.pojo.Activity;
import org.xuyk.elegant.practices.pojo.ActivityRequest;
import org.xuyk.elegant.practices.service.ActivityService;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/9/16
 */
@Slf4j
@Service
public class ActivityServiceImpl implements ActivityService {

    /**
     * 责任链初始化
     * @return
     */
    private ActivityFilterChain filterChainCreate(){
        ActivityFilterChain chain = new ActivityFilterChain();
        chain.addFilter(new ActivityInfoFilter());
        chain.addFilter(new ActivityUserFilter());
        return chain;
    }

    @Override
    public Activity create(ActivityRequest request) {
        // 1.请求参数校验
        filterChainCreate().doFilter(request);

        // 2.创建活动 此步骤省略
        Activity activity = new Activity();
        BeanUtil.copyProperties(request,activity);
        return activity;
    }

}
