package com.ecloud.aop;

import com.ecloud.bean.DBContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    //第一个*号：表示返回类型， *号表示所有的类型。包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，
    //表示类名，*号表示所有的类。*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
    @Pointcut("@annotation(com.ecloud.annotation.Master) " +
            "|| execution(* com.ecloud.dao..*.insert*(..)) " +
            "|| execution(* com.ecloud.dao..*.upsert*(..)) " +
            "|| execution(* com.ecloud.dao..*.add*(..)) " +
            "|| execution(* com.ecloud.dao..*.update*(..)) " +
            "|| execution(* com.ecloud.dao..*.edit*(..)) " +
            "|| execution(* com.ecloud.dao..*.delete*(..)) " +
            "|| execution(* com.ecloud.dao..*.remove*(..))")
    public void writePointcut() {

    }

    @Pointcut("!@annotation(com.ecloud.annotation.Master) " +
            "&& (execution(* com.ecloud.dao..*.select*(..)) " +
            "|| execution(* com.ecloud.dao..*.get*(..)))")
    public void readPointcut() {

    }

    @Before("writePointcut()")
    public void write() {
        DBContext.master();
    }

    @Before("readPointcut()")
    public void read() {
        DBContext.slave();
    }

}
