package com.ecloud;

import com.ecloud.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

//@SpringBootTest
public class RabbitmqProviderApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange.user}")
    private String userExchange;
    /**
     * 测试生产者
     */
    @Test
    public String sendMsg() {

        User user = new User();
        user.setUsername("abc");
        user.setAddress("def");
        //user.setBirthday(new Date());

        rabbitTemplate.convertAndSend(userExchange,"user.01",user);

        return "success";
    }


}
