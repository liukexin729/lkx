package com.ecloud.controllers;

import com.ecloud.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/redis")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/setKey")
    public String setKey(String str) {

        boolean kx = redisUtil.set(str, "kx");
        if (kx) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "/getValue")
    public String getKey(String key) {

        Object o = redisUtil.get(key);

        return o.toString();
    }
}
