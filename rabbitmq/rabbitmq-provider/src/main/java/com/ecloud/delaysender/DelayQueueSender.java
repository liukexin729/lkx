package com.ecloud.delaysender;

import com.ecloud.config.DelayQueueConfig;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Administrator
 */
@RestController
public class DelayQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send_1")
    public void main() {

        try {
            for (int i=0;i<=2;i++) {
                System.out.println("send time:"+new Date().toString());
                Thread.sleep(10000);
                rabbitTemplate.convertAndSend(DelayQueueConfig.DELAY_QUEUE_PER_QUEUE_TTL_NAME,
                        "Message from queue_ttl with expire_time" + DelayQueueConfig.QUEUE_EXPIRATION);
            }
        }catch (Exception e) {
            System.out.println("sender error");
        }


    }

    @PostMapping("/send_2")
    public void main1(){

        try {
            for (int i=0;i<=2;i++) {
                String expireTime = String.valueOf(i * 1000);
                MessageProperties messageProperties = new MessageProperties();
                messageProperties.setExpiration(expireTime);
                Message message = new Message("Message from queue_ttl".getBytes(),messageProperties);

                System.out.println("当前时间秒："+new Date().getSeconds());
                rabbitTemplate.convertAndSend(DelayQueueConfig.DELAY_PROCESS_QUEUE_NAME,message);
            }
        }catch (Exception e) {
            System.out.println("sender error");
        }
    }


}
