package com.ecloud.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class FanoutReceiver {

    @RabbitHandler
    @RabbitListener(queues = "myQueue1")
    public void getMsg(String msg) {
        System.out.println("first:"+msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "myQueue2")
    public void getMsg1(String msg) {
        System.out.println("second:"+msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "myQueue3")
    public void getMsg2(String msg) {
        System.out.println("third:"+msg);
    }

}
