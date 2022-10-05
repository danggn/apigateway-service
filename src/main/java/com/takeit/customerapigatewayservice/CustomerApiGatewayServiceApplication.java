package com.takeit.customerapigatewayservice;

import com.takeit.customerapigatewayservice.handler.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

import java.util.Objects;

@SpringBootApplication
@EnableEurekaClient
public class CustomerApiGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiGatewayServiceApplication.class, args);
    }

    @Bean
    public ErrorWebExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public KeyResolver tokenKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0));
    }
}
