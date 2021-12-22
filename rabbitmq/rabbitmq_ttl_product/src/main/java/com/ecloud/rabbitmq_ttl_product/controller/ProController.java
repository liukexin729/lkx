package com.ecloud.rabbitmq_ttl_product.controller;

import com.ecloud.entity.OrderMaster;
import com.ecloud.rabbitmq_ttl_product.mapper.OrderMasterMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author Administrator
 */
@RestController
public class ProController {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/test")
    public String createOrderTest(@RequestParam int time,@RequestParam String name) {
        OrderMaster orderMaster = new OrderMaster();
        //订单未完成
        orderMaster.setOrderStatus(0);
        //未付款
        orderMaster.setPayStatus(0);
        orderMaster.setBuyerName(name);
        orderMaster.setBuyerAddress("湖南长沙");
        orderMaster.setBuyerPhone("手机号");
        //orderMaster.setOrderAmount(BigDecimal.ZERO);
        orderMaster.setOrderAmount("3000");
        orderMaster.setCreateTime(new Date());
        orderMaster.setOrderId(UUID.randomUUID().toString().replaceAll("-", ""));
        orderMasterMapper.insert(orderMaster);


//        MessageProperties messageProperties = new MessageProperties();
//        messageProperties.setExpiration(String.valueOf(time));
//        Message message = new Message(orderMaster.toString().getBytes(),messageProperties);

        //第一个参数是前面RabbitMqConfig的交换机名称 第二个参数的路由名称 第三个参数是传递的参数 第四个参数是配置属性
        rabbitTemplate.convertAndSend("delay_exchange","delay_key",orderMaster,message -> {
            //配置消息的过期时间
            //message.getMessageProperties().setDelay(time);
            message.getMessageProperties().setHeader("x-delay",time);
            return message;
        });

        System.out.println("当前时间："+LocalDateTime.now());
        return "创建订单成功";
    }


}
