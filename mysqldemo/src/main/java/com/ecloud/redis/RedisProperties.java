package com.ecloud.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配置文件获取redis集群配置参数
 * @Author gkj
 * @Date 2020-08-20
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisProperties {
//    private int expireSeconds;
    private List<String> nodes;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }


}
