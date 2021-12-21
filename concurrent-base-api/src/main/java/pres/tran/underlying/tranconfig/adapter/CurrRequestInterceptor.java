package pres.tran.underlying.tranconfig.adapter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class CurrRequestInterceptor implements  HandlerInterceptor {



    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            CurrLetOff unInterception = method.getAnnotation(CurrLetOff.class);
            if (null != unInterception) {
                return true;
            }{
                String token = request.getHeader("token");
                if (StrUtil.isNotBlank(token)){
                    return true;
                }else {
                    return false;
                }
            }
        }catch (ClassCastException e){
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
