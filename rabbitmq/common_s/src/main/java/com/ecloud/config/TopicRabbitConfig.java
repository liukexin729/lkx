package com.ecloud.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 */
//@Configuration
public class TopicRabbitConfig {

    // 交换机
    @Bean
    public TopicExchange myTopicExchange() {
        return new TopicExchange("myTopicExchange", true, false);
    }

    /**
     * 给队列中的所有消息设置过期时间
     *(声明队列时设置1个x-message-ttl的属性，并设置过期时间，凡是推送到该队列中的所有消息，都会有一个30秒后过期的属性。)
     * @return
     */
    @Bean
    public Queue myTopicQueue_01() {
        Map<String,Object> map = new HashMap<>(16);
        map.put("x-message-ttl",30000);
        return new Queue("myTopicQueue_01", true,false,false,map);
        //return QueueBuilder.durable("myTopicQueue_01").withArgument("x-message-ttl",10000).build();
    }

    @Bean
    public Queue myTopicQueue_02() {
        return new Queue("myTopicQueue_02", true);
    }

    /**
     * 绑定路由键为topic.01
     */
    @Bean
    public Binding binding_01() {
        return BindingBuilder.bind(myTopicQueue_01()).to(myTopicExchange()).with("topic.01");
    }

    /**
     * 绑定路由键为topic.#规则
     */
//    @Bean
    public Binding binding_02() {
        return BindingBuilder.bind(myTopicQueue_02()).to(myTopicExchange()).with("topic.#");
    }

}
