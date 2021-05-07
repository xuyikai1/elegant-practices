package org.xuyk.elegant.practices.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.xuyk.elegant.practices.annotation.DistributedLock;
import org.xuyk.elegant.practices.exception.ServiceException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/9/24
 */
@Component
@Aspect
@Slf4j
public class DistributedLockAop {

    /**
     * redisson客户端
     */
    @Autowired
    private RedissonClient redissonClient;

    @Pointcut("@annotation(distributedLock)")
    public void distributeLockPointcut(DistributedLock distributedLock){}

    /**
     * 环绕增强
     * @param pjp
     * @param distributedLock
     */
    @Around(value = "distributeLockPointcut(distributedLock)", argNames = "pjp,distributedLock")
    public Object around(ProceedingJoinPoint pjp, DistributedLock distributedLock) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 请求路径
        String servletPath = request.getServletPath();
        // 用户ID 应该从token或者threadLocal中获取
        String userId = request.getParameter("userId");
        // 锁命名的密度可以根据具体业务再次细分 这里只根据用户和请求路径进行加锁处理
        String lockKey = userId + " | " + servletPath;

        RLock lock = redissonClient.getLock(lockKey);
        long waitTime = distributedLock.waitTime();
        long leaseTime = distributedLock.leaseTime();
        try{
            // 尝试加锁，最多等待lockTime毫秒，上锁以后leaseTime毫秒自动解锁
            if(!lock.tryLock(waitTime,leaseTime, TimeUnit.MILLISECONDS)){
                log.warn("lockKey = {}，重复提交！",lockKey);
                throw new ServiceException(201,"请勿重复提交！");
            }
            // 真正执行的方法
            return pjp.proceed();
        }catch (InterruptedException e) {
            log.warn("lockKey = {} ,  重复提交！",lockKey);
            throw new ServiceException(201, "请勿重复提交！");
        }finally {
            // 解锁(当前线程持有该锁才可进行解锁操作)
            if(lock.isLocked() && lock.isHeldByCurrentThread()){
                log.info("【分布式锁-解锁】lockKey:{}",lockKey);
                lock.unlock();
            }
        }
    }

}
