package com.wgc.springboottest.conf.datasource;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 翁国超
 * @Description // 配置mybatis的SessionFactory和SessionTemplate
 * @Date 2023/5/10
 **/
@Configuration
@MapperScan(value = "com.wgc.springboottest.dao.db1",sqlSessionFactoryRef = "sqlSessionFactoryBeanOne")
public class MybatisConfigOne {

    @Resource
    @Qualifier("dsOne")
    DataSource dsOne;

    @Resource
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Bean
    SqlSessionFactory sqlSessionFactoryBeanOne() throws Exception {
        // 原生SqlSessionFactoryBean
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dsOne);

        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dsOne);
//        mybatisSqlSessionFactoryBean.setPlugins(mybatisPlusInterceptor());

//        Interceptor[] plugins = new Interceptor[]{new PageHelper()};
//        mybatisSqlSessionFactoryBean.setPlugins(plugins);
        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db1/**/*.xml"));

        // 多数据源控制台打印sql，配置任意一个数据源即可
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        mybatisSqlSessionFactoryBean.setConfiguration(mybatisConfiguration);

        // 设置分页插件
        mybatisSqlSessionFactoryBean.setPlugins(mybatisPlusInterceptor);

        return mybatisSqlSessionFactoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBeanOne());
    }
}