package com.example.demo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: Xuyk
 * @Description: redisson配置类
 * @Date: 2020/9/24
 */
@Configuration
@EnableConfigurationProperties({RedissonProperties.class})
public class RedissonConfig {

    @Primary
    @Bean(name="defaultRedisClient",destroyMethod = "shutdown")
    public RedissonClient redissonClient(RedissonProperties redissonProperties){
        Config config = new Config();
        config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setDatabase(redissonProperties.getDatabase())
                // 连接最小初始化的个数
                .setConnectionMinimumIdleSize(10)
                .setPassword(redissonProperties.getPassword());
        return Redisson.create(config);
    }

}
