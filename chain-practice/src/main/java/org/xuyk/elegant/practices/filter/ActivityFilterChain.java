package org.xuyk.elegant.practices.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.xuyk.elegant.practices.pojo.ActivityRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xuyk
 * @Description: 活动请求的过滤责任链
 * @Date: 2020/9/14
 */
@Component
@Slf4j
public class ActivityFilterChain {

    private List<ActivityFilter> filters = new ArrayList<>();

    /**
     * 新增过滤器
     * @param filter
     */
    public void addFilter(ActivityFilter filter){
        filters.add(filter);
    }

    /**
     * 过滤
     * @param request
     * @return
     */
    public void doFilter(ActivityRequest request){
        int index = 0;
        while (index < filters.size()) {
            filters.get(index++).doFilter(request);
        }
    }

}
