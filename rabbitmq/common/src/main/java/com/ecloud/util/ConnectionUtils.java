package com.ecloud.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 */
public class ConnectionUtils {

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义Connection连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //设置服务地址，端口，协议
        connectionFactory.setHost("192.168.0.200");
        connectionFactory.setPort(122);
        //connectionFactory.setVirtualHost("/");
        //connectionFactory.setUsername("guest");
        //connectionFactory.setPassword("guest");

        return connectionFactory.newConnection();
    }

    public static void closeConn(Connection connection, Channel channel) throws IOException, TimeoutException {

        if (channel != null) {
            channel.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

}
