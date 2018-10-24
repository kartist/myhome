package com.angelachen.myhome.common.config;

import com.angelachen.myhome.common.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Kartist 2018/10/6 12:38
 */
@SpringBootConfiguration
public class MvcConfig implements WebMvcConfigurer {


    @Value("${config.file.prefix}")
    private String resourceLocation;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/home/index", "/backyard", "/comment/**", "/img/**")
                .excludePathPatterns("/user/login", "/user/logout", "/css/**", "/js/**", "/layui/**", "/index", "/images/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations(resourceLocation);
    }
}
