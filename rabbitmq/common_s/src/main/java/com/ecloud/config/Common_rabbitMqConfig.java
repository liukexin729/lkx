package com.ecloud.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
//@Configuration
public class Common_rabbitMqConfig {

    private static final String Exchange_Name = "exchange";

    private static final String Queue_Name = "queue";

    //交换机
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(Exchange_Name).durable(true).build();
    }

    //队列
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(Queue_Name).build();
    }

    //绑定
    @Bean
    public Binding myBinding(@Qualifier("bootQueue") Queue queue,@Qualifier("bootExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }
}
