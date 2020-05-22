package com.xu.configurations;

import com.xu.intercept.LoginHandlerIntercept;
import com.xu.resolver.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 首页登陆相关配置
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 配置请求拦截器
                registry.addInterceptor(new LoginHandlerIntercept()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/login.html","/asserts/**","/webjars/**");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 配置登陆路径映射
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
