package com.ecloud.rabbitmq_ttl_product.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */

//  Rabbitmq实现延时队列一般而言有两种形式：
//
//          第一种方式：利用两个特性： Time To Live(TTL)、Dead Letter Exchanges（DLX）
//
//          第二种方式：利用rabbitmq中的插件x-delayed-message

@Configuration
public class RabbitmqConfig {

    @Bean
    public CustomExchange delayExchange() {

        Map<String,Object> map = new HashMap<>();
        map.put("x-delayed-type","direct");
        //属性参数 交换机名称 交换机类型 是否持久化 是否自动删除 配置参数
        return new CustomExchange("delay_exchange", "x-delayed-message", true, false, map);

    }


//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange("delay_exchange",true,false);
//    }


    @Bean
    public Queue delayQueue() {

        return new Queue("delay_queue",true);

    }

    @Bean
    public Binding delayBind() {

        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with("delay_key").noargs();

    }


}
