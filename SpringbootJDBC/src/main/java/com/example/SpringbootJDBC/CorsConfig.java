package com.example.SpringbootJDBC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.applyPermitDefaultValues(); // You can customize this as needed
        corsConfig.addAllowedOrigin("*"); // Allow requests from any origin (customize as needed)
        corsConfig.addAllowedMethod("*");
        
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}
