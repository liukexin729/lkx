package com.ecloud.workqueue;

import com.ecloud.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 */
public class Send {

    private static final String QUEUE_NAME = "simple";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //每一个消费者发送确认收到消息之前，消息队列不发送下一个消息给消费者，一次只处理一个消息
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);

        for (int i = 0;i <= 9;i++) {
            String msg = "hello" + i;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println(msg);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //关闭连接
        ConnectionUtils.closeConn(connection,channel);
    }

}
