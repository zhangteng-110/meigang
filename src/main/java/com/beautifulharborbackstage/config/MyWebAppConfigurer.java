package com.beautifulharborbackstage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List converters) {
        // TODO Auto-generated method stub
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
   @Bean
    public HttpMessageConverter responseBodyConverter() {
     StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
     return converter;
   }
 
    // 如果不加，则静态资源会被拦截，导致访问不到静态资源
   @Override
   protected void addResourceHandlers(ResourceHandlerRegistry registry){
                  registry.addResourceHandler("/**")
                  .addResourceLocations("classpath:/resources/")
                  .addResourceLocations("classpath:/resources/")
                  .addResourceLocations("classpath:/static/")
                  .addResourceLocations("classpath:/public/");

                   registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                           "classpath:/META-INF/resources/");
                   registry.addResourceHandler("/webjars/**").addResourceLocations(
                            "classpath:/META-INF/resources/webjars/");
                   super.addResourceHandlers(registry);
   }
 
}