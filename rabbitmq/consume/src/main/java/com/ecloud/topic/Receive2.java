package com.ecloud.topic;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 *      topic: 模式匹配
 *            * (star) can substitute for exactly one word. 匹配不多不少恰好1个词
 *            # (hash) can substitute for zero or more words. 匹配一个或多个词
 *      audit.#    匹配audit.irs.corporate或者 audit.irs 等
 *      audit.*   只能匹配 audit.irs
 */
public class Receive2 {

    private static final String EXCHANGE_NAME = "exchange_topic";

    private static final String QUEUE_NAME = "simple7";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

//        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");
//        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"error");
//        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"warning");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"user.#");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"utf-8");
                System.out.println("receive2 msg:"+msg);
            }
        };

        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
