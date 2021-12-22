package com.ecloud.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 *消费者创建监听器(通道感知消息监听器)
 */
//@Component
public class MyAckReceiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        // 消息的唯一性ID
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            String msg = message.toString();
            System.out.println("消息:" + msg);
            System.out.println("消息来自:" + message.getMessageProperties().getConsumerQueue());

            //手动确认
            channel.basicAck(deliveryTag, true);
        }catch (Exception e){
            //拒绝策略
            //channel.basicAck(deliveryTag,false);
            //b1:true  重回队列（true），重新发送消息给消费端
            channel.basicNack(deliveryTag,true,true);
            e.printStackTrace();
        }
    }
}
