package com.example.demo.aspect;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONUtil;
import com.example.demo.annotation.ExceptionLog;
import com.example.demo.mapper.ExceptionLogMapper;
import com.example.demo.pojo.ExceptionLogInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Xuyk
 * @Description: 异常日志记录切面类
 * @Date: 2020/11/9
 */
@Aspect
@Component
@Slf4j
public class ExceptionLogAop {

    private final ExceptionLogMapper exceptionLogMapper;

    @Autowired
    public ExceptionLogAop(ExceptionLogMapper exceptionLogMapper) {
        this.exceptionLogMapper = exceptionLogMapper;
    }

    /**
     * 被 @exceptionLog 所注解的切点
     * @param exceptionLog
     */
    @Pointcut("@annotation(exceptionLog)")
    public void exceptionLogPointcut(ExceptionLog exceptionLog){}

    /**
     * 异常记录处理
     * @param joinPoint
     * @param exceptionLog
     * @param e
     */
    @AfterThrowing(value = "exceptionLogPointcut(exceptionLog)", throwing = "e", argNames = "joinPoint,exceptionLog,e")
    public void saveExceptionLog(JoinPoint joinPoint,ExceptionLog exceptionLog, Throwable e) {

        // 请求信息
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Signature signature = joinPoint.getSignature();

        // 持久化异常相关信息到数据库
        ExceptionLogInfo log = ExceptionLogInfo.builder()
                .apiPath(request.getServletPath())
                .apiMethod(request.getMethod())
                .uriPath(signature.getDeclaringTypeName() + "." + signature.getName())
                .requestParam(convertMap(request.getParameterMap()))
                .exMessage(ExceptionUtil.stacktraceToOneLineString(e))
                .createTime(DateUtil.date())
                .build();
        exceptionLogMapper.insertSelective(log);
    }

    /**
     * 请求参数格式转换
     * Map<String,String[]> -> Map<String,String>的json字符串
     * @param paramMap
     * @return
     */
    private String convertMap(Map<String,String[]> paramMap){
        Set<Map.Entry<String, String[]>> entries = paramMap.entrySet();
        if(!entries.isEmpty()){
            Map<String, String> map = new HashMap<>(entries.size());
            for (Map.Entry<String, String[]> entry : entries) {
                map.put(entry.getKey(),entry.getValue()[0]);
            }
            return JSONUtil.toJsonStr(map);
        }
        return "";
    }

}
