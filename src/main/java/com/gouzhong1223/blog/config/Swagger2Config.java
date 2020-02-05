package com.gouzhong1223.blog.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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


        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder username = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        username.name("username").description("用户名").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        pars.add(username.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gouzhong1223.blog.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .ignoredParameterTypes()
                .apiInfo(apiInfo());


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
