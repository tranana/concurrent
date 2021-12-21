package pres.tran.underlying.tranconfig.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CurrConfigurer implements WebMvcConfigurer  {

    @Autowired
    private CurrRequestInterceptor currRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(currRequestInterceptor);
        registration.addPathPatterns("**");
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(currRequestInterceptor);
    }

}
