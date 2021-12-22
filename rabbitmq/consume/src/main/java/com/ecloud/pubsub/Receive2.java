package com.ecloud.pubsub;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 */
public class Receive2 {

    private static final String EXCHANGE_NAME = "exchange_fanout";

    private static final String QUEUE_NAME = "simple2";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        //创建临时队列
        //String queue = channel.queueDeclare().getQueue();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        /**
         * 参数一： 队列名
         * 参数二： 交换机名
         * 参数三： 路由键
         */
        //绑定
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

        //消费回调接口
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"utf-8");
                System.out.println("receive2 msg:"+msg);
            }
        };

        //接受消息
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
