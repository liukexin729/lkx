package com.ecloud.springbootsender;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootSenderApplicationTests {

    @Test
    void contextLoads() {
        String[] str1 = {"abc","bac","cba"};

        Map<String, String[]> data = new HashMap<>(16);
        data.put("1",str1);
        //String dataJsonStr="";
        if (data != null) {
            String s = JSON.toJSONString(data);
            System.out.println(s);
        }
    }

}
