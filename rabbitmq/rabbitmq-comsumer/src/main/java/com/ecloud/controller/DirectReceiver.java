package com.ecloud.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */

/**
 * @RabbitListener 可以标注在类上面，需配合 @RabbitHandler 注解一起使用
 * @RabbitListener 标注在类上面表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型
 */
//@Component
//@RabbitListener(queues = "simple")
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "simple")
    public void process(String msg){
        System.out.println("simple:"+msg);
    }

//    @RabbitHandler
//    public void process(byte[] message){
//        System.out.println(new String(message));
//    }

    @RabbitHandler
    @RabbitListener(queues = "simple1")
    public void process1(String msg){
        System.out.println("simple1:"+msg);
    }
}
