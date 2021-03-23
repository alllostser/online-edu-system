package com.online.edu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: phone-contrast
 * @description:
 * @created: 2021/03/16 14:55
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 开启mybatisplus分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
