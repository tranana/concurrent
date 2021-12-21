package pres.tran.underlying.tranutil.redis;

import lombok.Getter;

/**
 * redis 使用的类
 */
public abstract class CurrBaseRedis implements CurrRedisPrefix{

    /**
     * redis 的前缀
     */
    private String  prefix;

    /**
     * 过期时间
     */
    private Integer expireSeconds;



    public CurrBaseRedis(String prefix, Integer expireSeconds) {
        this.prefix = prefix;
        this.expireSeconds = expireSeconds;
    }

    public CurrBaseRedis(String prefix) {
        this(prefix,0);
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getCurrPrefix() {
        return getClass().getSimpleName()+":"+prefix;
    }
}
