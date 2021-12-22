package com.ecloud.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 *
 * 生产者配置回调函数
 */
@Configuration
public class RabbitConfig {

    /**
     * 所有的消息发送都会转换成JSON格式发到交换机
     *
     * @param connectionFactory
     * @return
     */
    //自定义RabbitTemplate
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate();

        rabbitTemplate.setConnectionFactory(connectionFactory);

        //所有的消息发送都会转换成JSON格式发到交换机
        //rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

        //经检验得知，如果推送去一个不存在交换机上，那么就会触发confirm回调；如果推送去一个存在的交换机，但对应的路由键（或者说队列）不存在，则会触发return回调。
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             *
             * @param correlationData   相关配置信息
             * @param ack   exchange交换机是否成功接到消息，true 成功 ， false  失败
             * @param cause   失败原因（发送的交换机不存在）
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback: "+"相关数据：" + correlationData);
                System.out.println("ConfirmCallback: "+"确认情况：" + ack);
                System.out.println("ConfirmCallback: "+"原因：" + cause);

                //判断
                if (!ack) {
                    System.out.println("消息接受失败"+cause);
                }

            }
        });

        /**
         * mandatory：交换器无法根据自身类型和路由键找到一个符合条件的队列时的处理方式
         * true：RabbitMQ会调用Basic.Return命令将消息返回给生产者
         * false：RabbitMQ会把消息直接丢弃
         */
        //设置交换机处理失败的模式
        rabbitTemplate.setMandatory(true);

        //Confirm异步确认，收到服务端的ACK以后会调用
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returned) {
//                returned.getMessage();
//                returned.getExchange();
//                returned.getReplyCode();
//                returned.getReplyText();
//                returned.getRoutingKey();
                System.out.println("ReturnCallback: "+"消息对象：" + returned.getMessage());
                System.out.println("ReturnCallback: "+"错误码：" + returned.getReplyCode());
                System.out.println("ReturnCallback: "+"错误信息：" + returned.getReplyText());
                System.out.println("ReturnCallback: "+"交换机：" + returned.getExchange());
                System.out.println("ReturnCallback: "+"路由键：" + returned.getRoutingKey());

                //todo  路由失败处理

            }
        });

        return rabbitTemplate;
    }
}
