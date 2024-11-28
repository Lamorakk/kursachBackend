package com.unik.kursach3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/register").permitAll()
                        .requestMatchers("/api/login").permitAll()// Allow public access
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .formLogin(formLogin -> formLogin.defaultSuccessUrl("/dashboard", true))
                .logout(logout -> logout.logoutSuccessUrl("/login"));

        return http.build();
    }
}

