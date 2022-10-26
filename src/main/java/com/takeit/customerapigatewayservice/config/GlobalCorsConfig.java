package com.takeit.customerapigatewayservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

//@Configuration
public class GlobalCorsConfig {

    @Value("${allowedOrigin}")
    private String allowedOrigin;

    @Bean
    public CorsWebFilter corsWebFilter() {
        return new CorsWebFilter(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        source.registerCorsConfiguration("/**", corsConfiguration);
        corsConfiguration.addAllowedOrigin(allowedOrigin);
        corsConfiguration.setAllowedMethods(List.of(
                "GET",
                "POST",
                "DELETE",
                "PUT",
                "OPTIONS",
                "PATCH")
        );
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);

        return source;
    }

}
