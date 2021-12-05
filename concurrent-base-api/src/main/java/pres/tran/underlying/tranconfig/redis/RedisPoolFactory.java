package pres.tran.underlying.tranconfig.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisPoolFactory {

    @Autowired
    private RedisConfigBean redisConfigBean;

    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfigBean.getMaxIdle());
        poolConfig.setMaxTotal(redisConfigBean.getMaxActive());
        poolConfig.setMaxWaitMillis(redisConfigBean.getMaxWait());
        return new JedisPool(poolConfig,redisConfigBean.getHost(),redisConfigBean.getPort(),redisConfigBean.getTimeout(),redisConfigBean.getPassword());
    }

}
