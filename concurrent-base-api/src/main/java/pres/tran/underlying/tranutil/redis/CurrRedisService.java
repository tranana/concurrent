package pres.tran.underlying.tranutil.redis;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pres.tran.underlying.tranconfig.redis.RedisPoolFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

@Service
public class CurrRedisService {

    @Autowired
    private RedisPoolFactory redisPoolFactory;

    /**
     * 获取值
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(CurrRedisPrefix currRedisPrefix, String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            String value = jedis.get(currRedisPrefix.getCurrPrefix()+key);
            return stringToBean(value,clazz);
        }finally {
            resultsJedisPool(jedis);
        }
    }



    /**
     * 存入值
     * @param key
     * @param value
     * @return
     */
    public <T> String set(CurrRedisPrefix currRedisPrefix,String key,T value){
        Jedis jedis = null;
        String strValue = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            strValue = beanToValue(value);
            if (StrUtil.isNotBlank(strValue)){
                if (currRedisPrefix.expireSeconds() <= 0){
                    jedis.set(currRedisPrefix.getCurrPrefix()+key,strValue);
                }else {
                    jedis.setex(currRedisPrefix.getCurrPrefix()+key,currRedisPrefix.expireSeconds(),strValue);
                }
            }
        }finally {
            resultsJedisPool(jedis);
        }
        return strValue;
    }

    /**
     * key 是否存在
     * @param currRedisPrefix
     * @param key
     * @return
     */
    public boolean exists(CurrRedisPrefix currRedisPrefix,String key){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            return jedis.exists(currRedisPrefix.getCurrPrefix()+key);
        }finally {
            resultsJedisPool(jedis);
        }
    }

    /**
     * 增加 原子操作
     * @param currRedisPrefix
     * @param key
     * @return
     */
    public Long incr(CurrRedisPrefix currRedisPrefix,String key){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            return jedis.incr(currRedisPrefix.getCurrPrefix()+key);
        }finally {
            resultsJedisPool(jedis);
        }
    }

    /**
     * 减少 原子操作
     * @param currRedisPrefix
     * @param key
     * @return
     */
    public Long decr(CurrRedisPrefix currRedisPrefix,String key){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            return jedis.decr(currRedisPrefix.getCurrPrefix()+key);
        }finally {
            resultsJedisPool(jedis);
        }
    }

    /**
     * 将对象转为 json
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToValue(T value) {
        if (value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class || clazz == long.class || clazz == Long.class){
            return "" + value;
        }else if (clazz == String.class){
            return (String) value;
        }else {
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String value,Class<T> clazz) {
        if (value == null){
            return null;
        }
        if (clazz == int.class || clazz == Integer.class ){
            return (T)Integer.valueOf(value);
        }else if (clazz == String.class){
            return (T) value;
        }else if ( clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(value);
        } else {
            return JSON.toJavaObject(JSON.parseObject(value),clazz);
        }
    }


    /**
     * 放入连接池中
     *
     * @param jedis
     */
    private void resultsJedisPool(Jedis jedis) {
        if (null != jedis){
            jedis.close();
        }
    }

}
