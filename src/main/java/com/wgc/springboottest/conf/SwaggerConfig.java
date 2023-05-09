package com.wgc.springboottest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/5/9
 **/
@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo("Springboot项目测试",
                "APIs for My SpringbootTest.",
                "1.0",
                "Terms of service",
                new Contact("test", "www.org.com", "wengguochao@163.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("分组1")
                .select()
                /**
                 * RequestHandlerSelectors配置要扫描接口的方式
                 * basePackage:指定要扫描的包=>RequestHandlerSelectors.basePackage("com.wgc.springboottest.controller")
                 * any():扫描全部
                 * none():全部不扫描
                 * withClassAnnotation:扫描类上的注解=>RequestHandlerSelectors.withClassAnnotation(RestController.class)
                 * withMethodAnnotation:扫描方法上的注解=>RequestHandlerSelectors.withMethodAnnotation(GetMapping.class)
                 */
                .apis(RequestHandlerSelectors.any())
                /**
                 * Path：过滤路径
                 * ant:指定路径  eg: /test/**
                 * any:过滤全部
                 * none:全部不过滤
                 * regex:按照正则表达式来过滤
                 */
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("分组2")
                .select()
                /**
                 * RequestHandlerSelectors配置要扫描接口的方式
                 * basePackage:指定要扫描的包=>RequestHandlerSelectors.basePackage("com.wgc.springboottest.controller")
                 * any():扫描全部
                 * none():全部不扫描
                 * withClassAnnotation:扫描类上的注解=>RequestHandlerSelectors.withClassAnnotation(RestController.class)
                 * withMethodAnnotation:扫描方法上的注解=>RequestHandlerSelectors.withMethodAnnotation(GetMapping.class)
                 */
                .apis(RequestHandlerSelectors.any())
                /**
                 * Path：过滤路径
                 * ant:指定路径  eg: /test/**
                 * any:过滤全部
                 * none:全部不过滤
                 * regex:按照正则表达式来过滤
                 */
                .paths(PathSelectors.ant("/*/**"))
                .build();
    }
}
