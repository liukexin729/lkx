package com.ecloud.sixin_controller;

import com.ecloud.entity.User;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class Scontroller {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange.user}")
    private String userExchange;

    @PostMapping("/send_01")
    public String sendMsg() {

        User user = new User();
        user.setUsername("abc");
        user.setAddress("def");
        user.setBirthday(new Date().toString());

        //设置消息过期时间
//        MessageProperties messageProperties = new MessageProperties();
//        messageProperties.setExpiration("5000");
//        Message message = new Message(user.toString().getBytes(),messageProperties);

        rabbitTemplate.convertAndSend(userExchange, "user.01", user);

        return "success";
    }

    @PostMapping("/send_02")
    public String sendMsg1() {

        User user1 = new User();
        user1.setUsername("abc1");
        user1.setAddress("def1");

        User user2 = new User();
        user2.setUsername("abc2");
        user2.setAddress("def2");

        User user3 = new User();
        user3.setUsername("abc3");
        user3.setAddress("def3");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        try {
            for (int i = 0; i <list.size(); i++) {
                Thread.sleep(1000);
                rabbitTemplate.convertAndSend(userExchange, "user.01", list.get(i));
            }
        }catch (Exception e){
            System.out.println("发送消息失败");
        }

        return "success";
    }
}
