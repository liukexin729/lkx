package com.ecloud.sixin_controller;

import com.alibaba.fastjson.JSON;
import com.ecloud.entity.User;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author Administrator
 */
@Slf4j
@Component
public class AckConsumer {

    /**
     * 正常用户队列消息监听消费者
     *
     * @param user
     */
    @RabbitListener(queues = "${app.rabbitmq.queue.user}")
    public void userConsumer(User user) {
        log.info("正常用户业务监听：接收到消息:{}", JSON.toJSONString(user));
        throw new RuntimeException("模拟发生异常");
    }

    /**
     * @param user
     *  listener:
     *       simple:
     *         acknowledge-mode: auto
     */
    @RabbitHandler
    @RabbitListener(queues = "${app.rabbitmq.queue.user-dead-letter}")
    public void userDeadLetterConsumer(User user, Message message, Channel channel) throws IOException {

        log.info("接收到死信消息并自动签收:{}", JSON.toJSONString(user));
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
