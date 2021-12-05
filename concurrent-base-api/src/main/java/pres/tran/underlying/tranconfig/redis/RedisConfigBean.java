package pres.tran.underlying.tranconfig.redis;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "concurrent.redis")
@Data
public class RedisConfigBean {

    /**
     * Redis数据库索引
     */
    private String database;

    /**
     * Redis服务器地址
     */
    private String host;

    /**
     * Redis服务器连接端口
     */
    private Integer port;

    /**
     * Redis服务器连接密码
     */
    private String password;

    /**
     * 链接超时时间
     */
    private Integer timeout;

    /**
     * 连接池最大连接数
     */
    private Integer maxActive;

    /**
     * 连接池最大阻塞等待时间
     */
    private Integer maxWait;

    /**
     * 连接池中的最大空闲连接
     */
    private Integer maxIdle;

    /**
     * 连接池中的最小空闲连接
     */
    private String minIdle;
}
