package com.electric_diary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.electric_diary.controllers"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }	

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("API Documentation")
            .description("Documentation for your API")
            .version("1.0")
            .build();
    }
}