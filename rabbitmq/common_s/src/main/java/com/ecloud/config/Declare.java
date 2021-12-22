package com.ecloud.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
@Configuration
public class Declare {

    /**
     * 用户交换机
     */
    @Bean("userExchange")
    public Exchange userExchange(@Value("${app.rabbitmq.exchange.user}") String userExchangeName) {
        return ExchangeBuilder.topicExchange(userExchangeName)
                .durable(true)
                .build();
    }

    /**
     * 用户队列 (第一种情况： 用户拒签: Basic.nack或Basic.reject)
     */
//    @Bean("userQueue")
    public Queue userQueue(@Value("${app.rabbitmq.queue.user}") String userQueueName,
                           @Value("${app.rabbitmq.exchange.common-dead-letter}") String commonDeadLetterExchange) {
        return QueueBuilder
                //设置队列并持久化
                .durable(userQueueName)
                //声明该队列的死信消息发送到的 交换机 （队列添加了这个参数之后会自动与该交换机绑定，并设置路由键，不需要开发者手动设置)
                .withArgument("x-dead-letter-exchange", commonDeadLetterExchange)
                //声明该队列死信消息在交换机的 路由键
                .withArgument("x-dead-letter-routing-key", "user-dead-letter-routing-key")
                .build();
    }

    /**
     * 用户队列过期时间 （第二种情况）
     * @param userQueueName
     * @param commonDeadLetterExchange
     * @return
     */
    @Bean("userQueue")
    public Queue userQueue_ttl(@Value("${app.rabbitmq.queue.user}") String userQueueName,
                           @Value("${app.rabbitmq.exchange.common-dead-letter}") String commonDeadLetterExchange) {
        return QueueBuilder
                .durable(userQueueName)
                //声明该队列的死信消息发送到的 交换机 （队列添加了这个参数之后会自动与该交换机绑定，并设置路由键，不需要开发者手动设置)
                .withArgument("x-dead-letter-exchange", commonDeadLetterExchange)
                //声明该队列死信消息在交换机的 路由键
                .withArgument("x-dead-letter-routing-key", "user-dead-letter-routing-key")
                // 队列设置：在队列申明的时候使用 x-message-ttl 参数，单位为 毫秒
                .withArgument("x-message-ttl",5000)
                .build();
    }

    /**
     * 消息过期时间（第二种情况）
     * @param userQueueName
     * @param commonDeadLetterExchange
     * @return
     */
//    @Bean("userQueue")
    public Queue userQueue_message_ttl(@Value("${app.rabbitmq.queue.user}") String userQueueName,
                           @Value("${app.rabbitmq.exchange.common-dead-letter}") String commonDeadLetterExchange) {
        return QueueBuilder
                .durable(userQueueName)
                //声明该队列的死信消息发送到的 交换机 （队列添加了这个参数之后会自动与该交换机绑定，并设置路由键，不需要开发者手动设置)
                .withArgument("x-dead-letter-exchange", commonDeadLetterExchange)
                //声明该队列死信消息在交换机的 路由键
                .withArgument("x-dead-letter-routing-key", "user-dead-letter-routing-key")
                .build();
    }

    //（第三种情况： 超过了队列最大长度（距离消费端近的消息会进入死信队列）  自动签收）
//    @Bean("userQueue")
    public Queue userQueue_max_count(@Value("${app.rabbitmq.queue.user}") String userQueueName,
                           @Value("${app.rabbitmq.exchange.common-dead-letter}") String commonDeadLetterExchange) {
        return QueueBuilder
                .durable(userQueueName)
                //声明该队列的死信消息发送到的 交换机 （队列添加了这个参数之后会自动与该交换机绑定，并设置路由键，不需要开发者手动设置)
                .withArgument("x-dead-letter-exchange", commonDeadLetterExchange)
                //声明该队列死信消息在交换机的 路由键
                .withArgument("x-dead-letter-routing-key", "user-dead-letter-routing-key")
                //消息队列的消息最大长度为2
                .withArgument("x-max-length",2)
                .build();
    }

     /**
     * 交换机，队列绑定
     */
    @Bean
    public Binding bind(Queue userQueue, Exchange userExchange) {
        return BindingBuilder.bind(userQueue)
                .to(userExchange)
                .with("user.*")
                .noargs();
    }

    /**
     * 死信交换机
     */
    @Bean
    public Exchange commonDeadLetterExchange(@Value("${app.rabbitmq.exchange.common-dead-letter}") String commonDeadLetterExchange) {
        return ExchangeBuilder
                .topicExchange(commonDeadLetterExchange)
                .durable(true)
                .build();
    }

    /**
     * 用户队列的死信消息 路由的队列
     * 用户队列user-queue的死信投递到死信交换机`common-dead-letter-exchange`后再投递到该队列
     * 用这个队列来接收user-queue的死信消息
     *
     * @return
     */
    @Bean
    public Queue userDeadLetterQueue(@Value("${app.rabbitmq.queue.user-dead-letter}") String userDeadLetterQueue) {
        return QueueBuilder
                .durable(userDeadLetterQueue)
                .build();
    }

    /**
     * 死信队列绑定死信交换机
     *
     * @param userDeadLetterQueue      user-queue对应的死信队列
     * @param commonDeadLetterExchange 通用死信交换机
     * @return
     */
    @Bean
    public Binding userDeadLetterBinding(Queue userDeadLetterQueue, Exchange commonDeadLetterExchange) {
        return BindingBuilder
                .bind(userDeadLetterQueue)
                .to(commonDeadLetterExchange)
                .with("user-dead-letter-routing-key")
                .noargs();
    }

}
