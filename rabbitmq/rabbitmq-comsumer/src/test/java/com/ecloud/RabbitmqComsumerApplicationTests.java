package com.ecloud;

import com.ecloud.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;

//@SpringBootTest
class RabbitmqComsumerApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Test
    public void  test1() throws UnsupportedEncodingException {
        User user = new User();
        user.setUsername("abc");
        user.setAddress("def");
        user.setBirthday(new Date().toString());

        byte[] bytes = user.toString().getBytes();

        System.out.println(bytes);

        System.out.println(new String(bytes,"utf-8"));
    }
}
