package com.ecloud.simple;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare("simple",false,false,false,null);

        //定义消费者
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
               // super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"utf-8");
                System.out.println(msg);
            }
        };

        /**
         * 参数1：String queue 队列名称
         * 参数2：boolean autoAck 开启消息的自动确认机制
         * 参数3：Consumer callback  消费时回调接口
         */
        channel.basicConsume("simple",true,consumer);
    }
}
