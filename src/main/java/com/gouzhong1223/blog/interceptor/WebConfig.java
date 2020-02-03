package com.gouzhong1223.blog.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 拦截器拦截规则
 * @Date : create by QingSong in 2020-02-03 3:11 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.interceptor
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       /* registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/admin/login")
                .excludePathPatterns("/api/blog/allblogs")
                .excludePathPatterns("/api/blog/blogdetail/**")
                .excludePathPatterns("/api/blog/pagelist")
                .excludePathPatterns("/api/tag/listall")
                .excludePathPatterns("/api/type/listall");*/
    }
}
