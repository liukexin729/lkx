package com.ecloud.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class SendFanController {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @PostMapping("/send1")
    public String myMsg() {

        String msg = "hello fanout";

        rabbitTemplate.convertAndSend("myFanoutExchange",null,msg);

        return "success";
    }

}
