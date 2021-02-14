package com.zzk.codewhy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author zzk
 * @create 2021-02-14 1:30
 */
@Configuration
@MapperScan("com.zzk.codewhy.mapper")
public class MybatisPlusConfig {
}
