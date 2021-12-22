package com.ecloud.rabbitmq_ttl_receive.recevie;

import com.ecloud.entity.OrderMaster;
import com.ecloud.rabbitmq_ttl_receive.mapper.OrderMasterMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * @author Administrator
 */
@Component
public class OrderReceiver {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    //监听消息队列
    @RabbitListener(queues = "delay_queue")
    public void consumeMessage(OrderMaster order, Message message) throws IOException {
        try {
            //如果订单状态不是0 说明订单已经被其他消费队列改动过了 加一个状态用来判断集群状态的情况
            if (Objects.equals(0,order.getOrderStatus())) {
                //设置订单过去状态
                order.setOrderStatus(-1);
                System.out.println(order.getBuyerName());
                //System.out.println(new String((byte[]) message.getMessageProperties().getHeader("x-delay")));
                System.out.println(message.getMessageProperties().getDelay());
                System.out.println(LocalDateTime.now());
                orderMasterMapper.update(order,null);
            }
        } catch (Exception e) {
            System.out.println("接收消息失败");
        }
    }

}
