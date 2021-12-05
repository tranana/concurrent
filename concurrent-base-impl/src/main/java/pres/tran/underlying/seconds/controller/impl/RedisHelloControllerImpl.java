package pres.tran.underlying.seconds.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pres.tran.underlying.seconds.controller.RedisHelloController;
import pres.tran.underlying.tranutil.redis.CurrRedisService;

@Controller
@RequestMapping("/redis")
@ResponseBody
public class RedisHelloControllerImpl implements RedisHelloController {

    @Autowired
    private CurrRedisService currRedisService;

    @Override
    @GetMapping("/get")
    public String getKey(String key) {
        return currRedisService.get(key,String.class);
    }

    @Override
    @GetMapping("/set")
    public String setKeyAndValue(String key, String value) {
        return currRedisService.set(key,value);
    }
}
