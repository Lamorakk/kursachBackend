package com.unik.kursach3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Шлях до вашого API
                .allowedOrigins("http://localhost:5173") // Дозволений домен фронтенду
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Дозволені методи
                .allowedHeaders("*"); // Дозволені заголовки
    }
}
