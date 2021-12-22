package com.ecloud.springbootreceiver.msgreceiver;

import com.ecloud.common_l.entity.TLog;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author Administrator
 */
@Component
@Slf4j
public class LogConsumer {

   @RabbitHandler
   @RabbitListener(queues = "log.queue")
    public void msg(TLog tLog, Message message,Channel channel) throws IOException {
       log.info("打印消息:{}",tLog);
       channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
   }

}
