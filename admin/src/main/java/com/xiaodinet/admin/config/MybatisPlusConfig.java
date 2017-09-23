package com.xiaodinet.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.xiaodinet.admin.config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.xiaodinet.admin.dao")
public class MybatisPlusConfig {
    @Autowired
    public DruidProperties druidProperties;

    /**
     * park的数据库，连接池配置
     * @return
     */
    @Bean
    public DruidDataSource parkDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidProperties.config(druidDataSource);
        return druidDataSource;
    }

    /**
     * mybatis-plus分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
