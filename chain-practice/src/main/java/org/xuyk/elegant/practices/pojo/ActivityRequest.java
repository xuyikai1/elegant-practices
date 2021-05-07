package org.xuyk.elegant.practices.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyk
 * @Description: 活动请求类demo
 * @Date: 2020/9/14
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivityRequest {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 用户ID 一般用户ID会通过session/token进行传输 此处紧紧
     */
    private String userName;

}
