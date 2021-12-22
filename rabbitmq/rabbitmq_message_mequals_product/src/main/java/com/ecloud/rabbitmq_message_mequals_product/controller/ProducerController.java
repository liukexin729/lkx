package com.ecloud.rabbitmq_message_mequals_product.controller;

import com.ecloud.rabbitmq_message_mequals_product.product.FanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class ProducerController {

    @Autowired
    private FanoutProducer fanoutProducer;

    @PostMapping("/sendFanout")
    public String sendFanout(String queueName) {
        fanoutProducer.send(queueName);
        return "success";
    }

}
