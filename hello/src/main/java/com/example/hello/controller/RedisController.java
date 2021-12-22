package com.example.hello.controller;

import com.example.hello.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/setKey")
    public String success(String str) {

        boolean set = redisUtil.set(str, "kx");
        if (set) {
            return "success";
        }

        return "fail";
    }

    @RequestMapping(value = "/getValue")
    public String get(String key) {

        Object o = redisUtil.get(key);

        return o.toString();
    }
}
