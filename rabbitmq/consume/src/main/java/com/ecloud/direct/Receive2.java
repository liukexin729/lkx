package com.ecloud.direct;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 *          消费者： 声明交换机，队列   绑定路由键
 */
public class Receive2 {

    private static final String EXCHANGE_NAME = "exchange_direct";

    private static final String QUEUE_NAME = "simple4";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");
//        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"error");
//        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"warning");

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
