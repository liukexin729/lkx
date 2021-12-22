package com.example.hello.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key  键
     * @param time  时间（秒）
     */
    public boolean expire(String key,long time){
        try{
            if (time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key是否存在
     * @param  key 键
     * @return  true  存在  （false  不存在）
     */
    public boolean hasKey(String key){
        try{
            return redisTemplate.hasKey(key);    //hasKey方法
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param  key  可以穿一个值 或多个
     */
    public void del(String... key){
        if (key!=null&&key.length>0){
            if (key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
            }
        }
    }

    //========================String============================

    /**
     * 普通缓存获取
     * @param  key  键
     * @return  值
     */
    public Object get(String key){
        return key==null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存存放
     * @param  key  键
     * @param  value  值
     * @return  true成功  false失败
     */
    public boolean set(String key,Object value){
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存存放并设置时间
     * @param  key  键
     * @param  value  值
     * @param  time  时间（秒）time要大于0  如果time小于等于0，将设置无期限
     * @return  true成功  false失败
     */
    public boolean set(String key,Object value,long time){
        try{
            if (time>0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else {
                set(key,value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key  键
     * @param  delta  要增加几（大于0）
     */
    public long incr(String key,long delta){
        if (delta<0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * 递减
     * @param key  键
     * @param  delta  要减少几（大于0）
     */
    public long decr(String key,long delta){
        if (delta<0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key,delta);
    }

}
