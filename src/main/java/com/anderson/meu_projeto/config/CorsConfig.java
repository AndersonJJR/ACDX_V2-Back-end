package com.anderson.meu_projeto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    public void addCorsMapping(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
            .allowedMethods("*")
            .allowedOriginPatterns("*")
            .allowedHeaders("*")
            .maxAge(3600L)
            .exposedHeaders("Authorization")
            .allowCredentials(true);
    }

    
}
