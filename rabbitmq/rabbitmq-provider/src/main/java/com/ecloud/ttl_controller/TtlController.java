package com.ecloud.ttl_controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class TtlController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 指定消息的过期时间
     * (RabbitMQ只会对队列头部的消息进行过期淘汰。如果单独给消息设置TTL，先入队列的消息过期时间如果设置比较长，后入队列的设置时间比较短。会造成消息不会及时地过期淘汰，导致消息的堆积。)
     * @return
     */
    @PostMapping("/send4")
    public String sendMsg() {

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration("20000"); //单位 毫秒
//        messageProperties.setDelay(20000);    // 设置延迟时间,消息延迟发送

        String msg = "创建过期消息";
        Message message = new Message(msg.getBytes(),messageProperties);

        //public void send(final String exchange, final String routingKey,final Message message, @Nullable final CorrelationData correlationData)
        rabbitTemplate.convertAndSend("myTopicExchange","topic.01",message);

        return "success";
    }

    @PostMapping("/send5")
    public String sendMsg1() {

//        MessageProperties messageProperties = new MessageProperties();
//        messageProperties.setExpiration("20000"); //单位 毫秒
//
//        String msg = "创建过期消息";
//        Message message = new Message(msg.getBytes(),messageProperties);

        String message = "ttl";

        rabbitTemplate.convertAndSend("myTopicExchange","topic.01",message.getBytes());

        return "success";
    }

}
