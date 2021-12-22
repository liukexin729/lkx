package com.ecloud.springbootsender.aspect;

import com.alibaba.fastjson.JSON;
import com.ecloud.common_l.annotation.Log;
import com.ecloud.common_l.entity.TLog;
import com.ecloud.springbootsender.mapper.TLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Administrator
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private TLogMapper logMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //定义切入点，使用了该注解的方法将被AOP切入
    @Pointcut("@annotation(com.ecloud.common_l.annotation.Log)")
    public void logCut() {};

    @Before("logCut()")
    public void beforeLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //切入点（方法）
        Method method = signature.getMethod();
        //获取方法上的注解
        Log annotation = method.getAnnotation(Log.class);
        String type = annotation.logType().getType();
        String content = annotation.content();

        //获取request对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //ip
        String ip = request.getRemoteAddr();

        //请求数据
        Map<String, String[]> data = request.getParameterMap();
        String dataJsonStr="";
        if (data != null) {
            dataJsonStr = JSON.toJSONString(data);
        }

        TLog tLog = new TLog();
        tLog.setContent(content);
        tLog.setData(dataJsonStr);
        tLog.setIp(ip);
        tLog.setType(type);

        // 插入数据库
        long start = System.currentTimeMillis();
        logMapper.insert(tLog);
        log.info("直接插入数据库耗时：{}",System.currentTimeMillis()-start);

        start=System.currentTimeMillis();
        //  发消息队列
        rabbitTemplate.convertAndSend("log.exchange","aopLog",tLog.toString());
        log.info("发送mq消息耗时：{}",System.currentTimeMillis()-start);
    }


}
