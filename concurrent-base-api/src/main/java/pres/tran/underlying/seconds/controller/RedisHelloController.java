package pres.tran.underlying.seconds.controller;

public interface RedisHelloController {

    /**
     * 获取值
     * @param key
     * @return
     */
    String getKey(String key);

    /**
     * 存入值
     * @param key
     * @param value
     * @return
     */
    String setKeyAndValue(String key,String value);
}
