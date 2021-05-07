package org.xuyk.elegant.practices.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/9/24
 */
@Data
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    private String address;

    private Integer database;

    private String password;

}
