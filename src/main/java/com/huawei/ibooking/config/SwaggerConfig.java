//package com.huawei.ibooking.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.huawei.ibooking.controller"))
//                .build();
//    }
//
//    private ApiInfo getApiInfo() {
//        return new ApiInfoBuilder().title("ibooking API Documents").version("1.0").build();
//    }
//}
