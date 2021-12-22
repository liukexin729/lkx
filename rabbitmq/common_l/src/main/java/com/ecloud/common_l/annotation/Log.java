package com.ecloud.common_l.annotation;

import com.ecloud.common_l.entity.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 */
/** 类、接口（包括注解类型）或枚举声明 *//** Method declaration */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    LogType logType() default LogType.QUERY;

    String content() default "";

}
