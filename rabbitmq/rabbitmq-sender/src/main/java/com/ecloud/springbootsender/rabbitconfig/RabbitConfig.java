package com.ecloud.springbootsender.rabbitconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue logQueue(){
        return new Queue("log.queue");
    }

    @Bean
    public DirectExchange logExchange(){
        return new DirectExchange("log.exchange",true,false);
    }

    @Bean
    public Binding logBinding(){
        return BindingBuilder.bind(logQueue()).to(logExchange()).with("aopLog");
    }

}
