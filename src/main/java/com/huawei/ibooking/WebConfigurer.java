package com.huawei.ibooking;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);

        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:8090")  // 使用 allowedOriginPatterns 替代 allowedOrigins
                .allowCredentials(false)
                .allowedMethods("POST", "PUT", "OPTIONS", "DELETE", "GET")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
