package com.ecloud.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
//@RestController
public class SendDirectController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public String send(){

        String msg = "hello direct";

        rabbitTemplate.convertAndSend("myDirectExchange","error",msg);

        return "success";
    }

}
