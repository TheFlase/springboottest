package com.wgc.springboottest.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/24
 **/

@Component // 定义filterName 和过滤的url
@WebFilter(filterName = "my2Filter" ,urlPatterns = "/*")
@Slf4j
@ConditionalOnMissingFilterBean(value = {MyFilter.class})
public class MyFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("myFilter2 --->doFilter2");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("myFilter2 --->init()");
    }

    @Override
    public void destroy() {
        log.info("myFilter2 --->destroy");
    }
}
