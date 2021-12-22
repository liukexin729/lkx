package com.ecloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
//@Configuration
public class FanoutRabbitConfig {

    /**
     * 交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange myFaFanoutExchange() {
        return new FanoutExchange("myFanoutExchange",true,false);
    }

    /**
     * 队列
     *
     * @return
     */
    @Bean
    public Queue myQueue_f1() {
        return new Queue("myQueue1",true,false,false,null);
    }

    @Bean
    public Queue myQueue_f2() {
        return new Queue("myQueue2",true,false,false,null);
    }

    @Bean
    public Queue myQueue_f3() {
        return new Queue("myQueue3",true,false,false,null);
    }

    /**
     * 绑定
     */
    @Bean
    public Binding myBinding1() {
        return BindingBuilder.bind(myQueue_f1())
                .to(myFaFanoutExchange());
    }

    @Bean
    public Binding myBinding2() {
        return BindingBuilder.bind(myQueue_f2())
                .to(myFaFanoutExchange());
    }

    @Bean
    public Binding myBinding3() {
        return BindingBuilder.bind(myQueue_f3())
                .to(myFaFanoutExchange());
    }

}
