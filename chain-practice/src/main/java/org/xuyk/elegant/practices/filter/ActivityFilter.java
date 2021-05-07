package org.xuyk.elegant.practices.filter;

import org.xuyk.elegant.practices.pojo.ActivityRequest;

/**
 * @Author: Xuyk
 * @Description: 活动过滤接口定义
 * @Date: 2020/9/14
 */
public interface ActivityFilter {

    /**
     * 对活动请求进行过滤
     * @param activityRequest
     * @return
     */
    void doFilter(ActivityRequest activityRequest);

}
