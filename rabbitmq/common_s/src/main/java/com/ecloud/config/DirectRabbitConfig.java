package com.ecloud.config;

import com.ecloud.en_um.RoutingKey;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
//@Configuration
public class DirectRabbitConfig {

    /**
     * 交换机
     */
    @Bean
    public DirectExchange myDirectExchange(){
        // 参数意义:
        // name: 名称
        // durable: true
        // autoDelete: 自动删除
        return new DirectExchange("myDirectExchange",true,false);
    }

    /**
     * 队列
     */
    @Bean
    public Queue myQueue(){
        return new Queue("simple",true,false,false,null);
    }

    @Bean
    public Queue myQueue1(){
        return new Queue("simple1",true,false,false,null);}
    /**
     * 绑定
     */
    @Bean
    public Binding bindingDirect_0(){
        return BindingBuilder.bind(myQueue())
                .to(myDirectExchange())
                //路由键my.* 或 my.#
                .with("info");

    }

    @Bean
    public Binding bindingDirect_1(){
        return BindingBuilder.bind(myQueue())
                .to(myDirectExchange())
                //路由键my.* 或 my.#
                .with("error");

    }

    @Bean
    public Binding bindingDirect_2(){
        return BindingBuilder.bind(myQueue())
                .to(myDirectExchange())
                //路由键my.* 或 my.#
                .with("warning");
    }

    @Bean
    public Binding bindingDirect_3(){
        return BindingBuilder.bind(myQueue1())
                .to(myDirectExchange())
                //路由键my.* 或 my.#
                .with("error");

    }

}
