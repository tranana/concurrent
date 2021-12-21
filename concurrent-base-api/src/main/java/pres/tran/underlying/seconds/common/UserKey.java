package pres.tran.underlying.seconds.common;

import pres.tran.underlying.tranutil.redis.CurrBaseRedis;

public class UserKey extends CurrBaseRedis {


    private UserKey(String prefix, Integer expireSeconds) {
        super(prefix, expireSeconds);
    }

    private UserKey(String prefix) {
        super(prefix, 0);
    }


    public static UserKey getToken = new UserKey("token",86400);
}
