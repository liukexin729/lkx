package com.ecloud.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Administrator
 */
//@Component
public class TopicReceiver {

//    @RabbitHandler
//    @RabbitListener(queues = "myTopicQueue_01")
//    public void getMsg(String msg) {
//
//        System.out.println(msg);
//
//    }
//
//    @RabbitHandler
//    @RabbitListener(queues = "myTopicQueue_02")
//    public void getMsg1(String msg) {
//
//        System.out.println(msg);
//
//    }

        @RabbitHandler
        @RabbitListener(queues = "myTopicQueue_01")
        public void getMsg(Message msg, Channel channel) throws IOException {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println("myTopicQueue_01:"+msg.getMessageProperties().getDeliveryTag());
            long deliveryTag = msg.getMessageProperties().getDeliveryTag();

            //手动确认
            channel.basicAck(deliveryTag,true);

            System.out.println("myTopicQueue_01:"+new String(msg.getBody()));
        }

//        @RabbitHandler
//        @RabbitListener(queues = "myTopicQueue_02")
//        public void getMsg1(Message msg) {
//
//            System.out.println("myTopicQueue_02:"+msg.getMessageProperties().getDeliveryTag());
//            System.out.println("myTopicQueue_02:"+new String(msg.getBody()));
//        }
}
