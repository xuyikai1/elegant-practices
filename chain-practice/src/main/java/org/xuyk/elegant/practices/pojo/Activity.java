package org.xuyk.elegant.practices.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyk
 * @Description: 活动实体类
 * @Date: 2020/9/14
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Activity {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

}
