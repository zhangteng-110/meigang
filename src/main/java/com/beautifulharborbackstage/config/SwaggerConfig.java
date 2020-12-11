package com.beautifulharborbackstage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhangteng
 * @date: Created in 15:39 2020/12/8
 */
@Configuration//托管spring
@EnableSwagger2//开启swagger功能
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        //版本类型是swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                //通过调用自定义方法apiInfo，获得文档的主要信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.beautifulharborbackstage.controller"))//扫描该包下面的API注解
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("meigang计划接口Api") //接口管理文档首页显示
                .description("zy - Swagger使用演示")//API的描述
                .termsOfServiceUrl("www.footmark.top")//网站url等
                .version("1.0")
                .build();
    }
}