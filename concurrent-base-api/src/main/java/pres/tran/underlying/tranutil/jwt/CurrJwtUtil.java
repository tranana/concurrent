package pres.tran.underlying.tranutil.jwt;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pres.tran.underlying.seconds.dto.UserResultDTO;
import pres.tran.underlying.tranutil.redis.CurrRedisService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class CurrJwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(CurrJwtUtil.class);

    /**
     * token的key
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * token值的前缀
     */
    public static final String TOKEN_PREFIX = "tran";

    /**
     * 加密时候用  是对称的秘钥盐
     */
    private static final String SECRET = "mrLang";

    /**
     * 获取用户的功能使用的key
     */
    public static final String FUNCTS = "FUNCTS";

    /**
     * 获取用户使用的key
     */
    public static final String USERINFO = "USER";

    /**
     * token 的存活时间
     */
    private static final long EXPIRATION = 86400L;

    /**
     * 创建token令牌 以下为参数都是自定义信息
     *
     * @param loginName 一般我们放用户的唯一标识登录名
     * @param functs    当前用户的功能集合，
     *                  本人的rbac权限比较个性化且很负责，一般你们放role角色就可以了
     * @param user      当前用户
     * @return
     */
    public static String createToken(String loginName,
                                     List<Object> functs, UserResultDTO user) {
        Map<String, Object> map = new HashMap<>();
        if (functs != null){
            //当前用户拥有的功能
            map.put(FUNCTS, JSON.toJSONString(functs));
        }
        //当前用户信息
        map.put(USERINFO, JSON.toJSONString(user));

        // 设置HS256加密，使用SH256证书加密
        String token = Jwts.builder()
                .setSubject(loginName)//登录名
                .setClaims(map)
                .setIssuedAt(new Date())//设置发布时间，也是生成时间
                .setExpiration(new Date(System.currentTimeMillis()
                        + EXPIRATION * 1000))//设置过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        return token;
    }

    /**
     *  公共获取自定义数据
     * @param token
     * @return
     */
    public static Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
    }

    /**
     * 验证Token是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    // 获取主角，登录名
    public static String getUserName(String token) {
        return getTokenBody(token).getSubject();
    }

    // 获取token中存储的功能
    public static List<Object> getUserFuncts(String token) {
        String str = getTokenBody(token).get(FUNCTS).toString();
        List<Object> list = JSON.parseArray(str, Object.class);
        return list;
    }

    // 获取token存储的用户
    public static <T>  T getUser(String token,Class<T> clazz) {
        String str = getTokenBody(token).get(USERINFO).toString();
        return JSON.parseObject(str, clazz);
    }

    public static String refreshToken(String token) {
        if (isExpiration(token)) {
            logger.info("token刷新失败！！ 过期了！！"); return null;
        }

        // 获取用户 权限信息
        String functs = getTokenBody(token).get(FUNCTS).toString();
        String user = getTokenBody(token).get(USERINFO).toString();
        String username = getTokenBody(token).getSubject();
        Map<String, Object> map = new HashMap<>();
        //当前用户拥有的功能
        map.put(FUNCTS, JSON.toJSONString(functs));
        //当前用户信息
        map.put(USERINFO, JSON.toJSONString(user));
        token = Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET)
                .setClaims(map).setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();
        return token;
    }

}