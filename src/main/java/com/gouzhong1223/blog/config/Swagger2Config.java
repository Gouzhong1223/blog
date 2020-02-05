package com.gouzhong1223.blog.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : Swagger2Config
 * @Date : create by QingSong in 2020-02-05 4:13 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.config
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@EnableSwagger2
@SpringBootConfiguration
public class Swagger2Config {

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定提供接口所在的基包
                .apis(RequestHandlerSelectors.basePackage("com.gouzhong1223.blog.controller"))
//                .apis(RequestHandlerSelectors.basePackage("com.gouzhong1223.blog.controller.admin"))
                .build();
    }

    /**
     * 该套 API 说明，包含作者、简介、版本、host、服务URL
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Blog后端接口文档")
                .contact(new Contact("Gouzhong1223", "http://www.gouzhong1223.com", "gouzhong1223@gmail.com"))
                .version("1.0.0")
                .termsOfServiceUrl("localhost:8089/api/")
                .description("接口")
                .build();
    }
}
