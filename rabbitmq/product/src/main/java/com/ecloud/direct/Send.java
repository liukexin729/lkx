package com.ecloud.direct;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 *          生产者： 声明交换机，发送消息（声明路由键）
 *
 */
public class Send {

    private static final String EXCHANGE_NAME = "exchange_direct";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        //声明交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String msg = "hello direct";
        //String routingKey = "error";
        String routingKey = "info";
        //向交换机发送消息
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());

        ConnectionUtils.closeConn(connection,channel);
    }

}
