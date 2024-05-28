package com.tickethub.backend.user.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(60 * 60 * 24)
                //.allowedOrigins("http://k8s-default-prodingr-fc22219cb1-577453725.ap-northeast-2.elb.amazonaws.com");
                .allowedOrigins("http://localhost:3000");
    }
}
