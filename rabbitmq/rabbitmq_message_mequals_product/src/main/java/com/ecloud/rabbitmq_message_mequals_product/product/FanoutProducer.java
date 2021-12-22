package com.ecloud.rabbitmq_message_mequals_product.product;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * @author Administrator
 */
@Slf4j
@Component
public class FanoutProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String queue) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "xx@163.com");
        jsonObject.put("timestamp", System.currentTimeMillis());
        String s = jsonObject.toJSONString();
        log.info("打印json字符串:{}",s);

        // 设置消息唯一id 保证每次重试消息id唯一(保证消息幂等性，不被重复消费)
        Message message = MessageBuilder.withBody(s.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON)
                                        .setContentEncoding("utf-8")
                                        //消息id设置在请求头里面 用UUID做全局ID
                                        .setMessageId(UUID.randomUUID().toString()+"")
                                        .build();

        rabbitTemplate.convertAndSend(queue , message);
    }
}
