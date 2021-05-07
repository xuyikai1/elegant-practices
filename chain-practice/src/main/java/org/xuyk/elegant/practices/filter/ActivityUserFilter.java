package org.xuyk.elegant.practices.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xuyk.elegant.practices.exception.ActivityException;
import org.xuyk.elegant.practices.pojo.ActivityRequest;

import static org.xuyk.elegant.practices.pojo.ResultDto.FAIL_CODE;


/**
 * @Author: Xuyk
 * @Description: 活动用户相关过滤，例如用户参与次数校验等
 *               优先级：2
 * @Date: 2020/9/14
 */
@Service
@Slf4j
public class ActivityUserFilter implements ActivityFilter {

    @Override
    public void doFilter(ActivityRequest activityRequest) {

        log.info("【活动过滤器】{}",activityRequest);

        // 1.校验用户是否合法 不合法则抛出Activity异常

        // 2.校验用户是否可参与活动

        // 3.校验用户参与活动次数是否用完

        // 判空等操作可通过hibernate.validation里的注解代替，此处仅用来测试之用
        String userName = activityRequest.getUserName();
        if(StrUtil.isBlank(userName)){
            throw new ActivityException(FAIL_CODE,"请输入用户名称");
        }
    }

}
