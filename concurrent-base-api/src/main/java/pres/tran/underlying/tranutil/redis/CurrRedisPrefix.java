package pres.tran.underlying.tranutil.redis;

public interface CurrRedisPrefix {

     int expireSeconds();

     String getCurrPrefix();

}
