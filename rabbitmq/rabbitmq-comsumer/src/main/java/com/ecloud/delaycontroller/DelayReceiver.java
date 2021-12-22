package com.ecloud.delaycontroller;

import com.ecloud.config.DelayQueueConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author Administrator
 */
@Component
public class DelayReceiver {

    @RabbitHandler
    @RabbitListener(queues = DelayQueueConfig.DELAY_PROCESS_QUEUE_NAME)
    public void receiveMsg(Message message) {
        System.out.println(message.getMessageProperties().getExpiration()+new String(message.getBody()));
    }

}
