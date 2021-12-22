package com.ecloud.pubsub;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 *
 *订阅者模式
 *      生产者： 绑定交换机
 *      消费者： 创建队列，绑定交换机
 */


public class Send {

    private static final String EXCHANGE_NAME = "exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        String msg = "hello pubsub";
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());

        System.out.println("send message:"+msg);

        //关闭连接
        ConnectionUtils.closeConn(connection,channel);
    }

}
