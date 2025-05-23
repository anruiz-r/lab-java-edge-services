package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("students-info-service", r -> r.path("/api/students/**")
                        .uri("lb://students-info-service"))
                .route("grades-data-service", r -> r.path("/api/grades/**", "/api/courses/**")
                        .uri("lb://grades-data-service"))
                .route("catalog-service", r -> r.path("/api/catalog/**")
                        .uri("lb://catalog-service"))
                .build();
    }
}

