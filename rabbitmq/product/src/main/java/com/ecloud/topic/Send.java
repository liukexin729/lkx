package com.ecloud.topic;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 */
public class Send {

    private static final String EXCHANGE_NAME = "exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        //声明交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String msg = "hello topic";
        //String routingKey = "user.save";
        String routingKey = "user.save.1";

        //向交换机发送消息
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());

        ConnectionUtils.closeConn(connection,channel);
    }
}
