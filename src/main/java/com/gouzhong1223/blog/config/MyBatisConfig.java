package com.gouzhong1223.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : MyBatisConfig
 * @Date : create by QingSong in 2020-02-01 5:55 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.config
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Configuration
@MapperScan("com.gouzhong1223.blog.mapper")
@Transactional
public class MyBatisConfig {
}
