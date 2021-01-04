package com.beautifulharborbackstage.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

  @Autowired
  private LoginInterceptor loginInterceptor;

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    List<String> asList = Arrays.asList("/user/register", "/user/login");
    registry.addInterceptor(loginInterceptor).excludePathPatterns(asList);
  }
}