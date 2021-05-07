package org.elegant.practice.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/20
 */
@Data
@Builder
public class ThreadPoolRequest {

    private Integer corePoolSize;

    private Integer maximumPoolSize;

}
