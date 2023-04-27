package com.wgc.springboottest.conf;

import com.wgc.springboottest.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("MyFilter");
        filterRegistrationBean.setOrder(10);
        return filterRegistrationBean;
    }
}
