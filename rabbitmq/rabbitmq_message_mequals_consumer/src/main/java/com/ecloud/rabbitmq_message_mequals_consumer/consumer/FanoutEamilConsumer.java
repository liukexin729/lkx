package com.ecloud.rabbitmq_message_mequals_consumer.consumer;




import com.alibaba.fastjson.JSONObject;
import com.ecloud.rabbitmq_message_mequals_consumer.config.RedisConfig;
import com.ecloud.rabbitmq_message_mequals_consumer.util.HttpClientUtils;
import com.ecloud.rabbitmq_message_mequals_consumer.util.RedisUtil;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class FanoutEamilConsumer {

    @Autowired
    private RedisUtil redisUtil;

    private static Logger log = LoggerFactory.getLogger(FanoutEamilConsumer.class);

    @RabbitHandler
    @RabbitListener(queues = "fanout_email_queue")
    public void process(Message message, Channel channel) throws Exception {

        //获取消息的id
        String messageId = message.getMessageProperties().getMessageId();
        //获取消息 body
        String msg = new String(message.getBody(), "utf-8");

        log.info("接受消息的id:{}",messageId);
        log.info("接受生产者的消息:{}",msg);

        //从redis中获取messageId
        String messageId1 = (String) redisUtil.get("messageId");

        if (messageId == messageId1) {
            return;
        }

        JSONObject jsonObject = JSONObject.parseObject(msg);
        // 获取email参数
        String email = jsonObject.getString("email");

        //发送get请求
        String emailUrl = "http://127.0.0.1:8083/sendEmail?email=" + email;
        JSONObject result = HttpClientUtils.httpGet(emailUrl);
        if (result == null) {
            // 因为网络原因,造成无法访问,继续重试
            throw new Exception("调用接口失败!");
        }

        //手动ack
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //手动签收   false：只确认所提供的交付标签    true：确认直到并包括所提供的交付标记的所有消息
        channel.basicAck(deliveryTag, false);

        System.out.println("执行结束....");

        //todo messageId 的情况写入到redis 中  成功就修改为空
        redisUtil.set("messageId",messageId);
    }
}

