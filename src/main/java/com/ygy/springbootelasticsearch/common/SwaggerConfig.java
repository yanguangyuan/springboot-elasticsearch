package com.ygy.springbootelasticsearch.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yanguangyuan
 * @Date: 2018/12/29 10:48
 * @Description: swagger配置文件
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages="com.ygy.springbootelasticsearch.controller")
public class SwaggerConfig {
    @Bean
    public Docket api(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("api-1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ygy.springbootelasticsearch.controller"))
                .build().globalOperationParameters(pars);
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("项目API文档")
                .description("HTTP对外开放接口")
                .version("1.0.0")
                .termsOfServiceUrl("http://localhost:8889")
                .license("LICENSE")
                .build();
    }
}
