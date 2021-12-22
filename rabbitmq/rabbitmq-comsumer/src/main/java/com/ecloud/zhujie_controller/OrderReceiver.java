package com.ecloud.zhujie_controller;

import com.ecloud.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



import java.io.IOException;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class OrderReceiver {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order-queue",durable = "true")
        ,exchange = @Exchange(value = "order-exchange",durable = "true",type = "topic")
        ,key = "order.#"
    ))
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String,Object> headers, Channel channel) throws IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("订单ID是：" + order.getId());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, true);
        System.out.println("订单ID是：" + order.getId());
    }

}
