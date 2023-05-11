
package com.wgc.springboottest.conf.datasource;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Author 翁国超
 * @Description // 配置mybatis的SessionFactory和SessionTemplate
 * @Date 2023/5/10
 **/
@Configuration
@MapperScan(value = "com.wgc.springboottest.dao.db2",sqlSessionFactoryRef = "sqlSessionFactoryBeanTwo")
public class MybatisConfigTwo {

    @Resource
    @Qualifier("dsTwo")
    DataSource dsTwo;

    @Resource
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Bean
    SqlSessionFactory sqlSessionFactoryBeanTwo() throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dsTwo);
        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/db2/**/*.xml"));

        // 设置分页插件
        mybatisSqlSessionFactoryBean.setPlugins(mybatisPlusInterceptor);
        return mybatisSqlSessionFactoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBeanTwo());
    }
}