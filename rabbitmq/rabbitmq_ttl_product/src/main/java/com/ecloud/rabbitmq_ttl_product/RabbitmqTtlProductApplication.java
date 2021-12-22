package com.ecloud.rabbitmq_ttl_product;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqTtlProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTtlProductApplication.class, args);
    }

}
