package com.ecloud.sixin_controller;

import com.alibaba.fastjson.JSON;
import com.ecloud.entity.User;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author Administrator
 *
 * 消息被(basic.reject() or basic.nack()) and requeue = false，即消息被消费者拒绝或者nack，并且重新入队为false。
 *
 * nack()与reject()的区别是：reject()不支持批量拒绝，而nack()可以.
 *
 */
@Slf4j
@Component
public class SixinReceiver {

    /**
     * 拒签情况
     *
     * @param user
     * @param message
     * @param channel
     */
//    @RabbitHandler
//    @RabbitListener(queues = "${app.rabbitmq.queue.user}")
    public void userReceive(User user,Message message, Channel channel) {
        log.info("正常用户业务监听：接收到消息:{}", JSON.toJSONString(user));

        try{
            //拒签，消息到死信队列
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            log.info("拒签消息的路由键:{}",message.getMessageProperties().getReceivedRoutingKey());
            log.info("拒签消息的队列:{}",message.getMessageProperties().getConsumerQueue());
        }catch (Exception e){
            log.info("拒签消息失败");
        }
    }

    @RabbitHandler
    @RabbitListener(queues = "${app.rabbitmq.queue.user-dead-letter}")
    public void userDeadLetterConsumer1(User user,Message message, Channel channel) {
        log.info("接收到的死信消息:{}",JSON.toJSONString(user));

        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);    //  //multiple: 数量多的
            log.info("死信消息的路由键:{}",message.getMessageProperties().getReceivedRoutingKey());
            log.info("死信消息的队列:{}",message.getMessageProperties().getConsumerQueue());
        }catch (Exception e) {
            log.info("接受消息失败");
        }
    }

}
