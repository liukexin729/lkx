package com.ecloud.rabbitmq_ttl_receive;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqTtlReceiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTtlReceiveApplication.class, args);
    }

}
