package com.ecloud.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class SendTopicController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send2")
    public String sendMsg() {

        String msg = "hello topic";

        for (int i=0; i<=15; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rabbitTemplate.convertAndSend("myTopicExchange","topic.01",i+"topic.01");
        }

        //rabbitTemplate.convertAndSend("myTopicExchange","topic.01.first",msg+"topic.01.first");

        return "success";
    }

}
