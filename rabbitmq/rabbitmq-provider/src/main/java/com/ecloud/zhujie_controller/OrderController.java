package com.ecloud.zhujie_controller;

import com.ecloud.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Administrator
 */
@RestController
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send3")
    public void sendMsg() {

            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //id + 时间戳 全局唯一
                CorrelationData correlationData = new CorrelationData("1234567890"+new Date());
                rabbitTemplate.convertAndSend("order-exchange", "order.01", new Order("1","order","message_1") , correlationData);
            }
        }
}
