package com.ecloud.controllers;

import com.ecloud.redis.RedisConfig;
import com.ecloud.redis.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

/**
 * @author Administrator
 */
//@RestController
//public class RedisController {
//
//    @Autowired
//    private RedisProperties redisProperties;
//
//    @Autowired
//    private RedisConfig redisConfig;
//
//    @Autowired
//    private JedisCluster jedisCluster;
//
//    @PostMapping("/getRedisValue")
//    public String getRedisValue(){
//        System.out.println(redisProperties.toString());
//        System.out.println(redisConfig.getJedisCluster().getClusterNodes());
//        System.out.println(jedisCluster.get("key1"));
//        jedisCluster.set("12","12");
//        System.out.println(jedisCluster.get("12"));
//        return jedisCluster.get("12");
//    }
//
//}
