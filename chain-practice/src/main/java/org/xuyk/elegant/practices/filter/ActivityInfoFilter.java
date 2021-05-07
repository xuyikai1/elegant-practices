package org.xuyk.elegant.practices.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xuyk.elegant.practices.exception.ActivityException;
import org.xuyk.elegant.practices.pojo.ActivityRequest;

import static org.xuyk.elegant.practices.pojo.ResultDto.FAIL_CODE;


/**
 * @Author: Xuyk
 * @Description: 活动过滤器，例如校验活动是否开启等
 *               优先级：1
 * @Date: 2020/9/14
 */
@Service
@Slf4j
public class ActivityInfoFilter implements ActivityFilter {

    @Override
    public void doFilter(ActivityRequest activityRequest) {

        log.info("【活动基础过滤器】{}",activityRequest);

        // 1.校验活动是否开启 不合法则抛出Activity异常

        // 2.校验活动总参与次数是否用完

        // ...

        // 判空等操作可通过hibernate.validation里的注解代替，此处仅用来测试之用
        String activityName = activityRequest.getActivityName();
        if(StrUtil.isBlank(activityName)){
            throw new ActivityException(FAIL_CODE,"请输入活动名称");
        }

    }

}
