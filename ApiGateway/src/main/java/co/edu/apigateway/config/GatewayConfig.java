package co.edu.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Rutas para UserService
                .route("user_route", r -> r
                        .path("/tienda/auth/**", "/tienda/cliente/**", "/tienda/proveedor/**")
                        .uri("http://localhost:8081"))

                // Rutas para ProductService
                .route("product_route", r -> r
                        .path("/tienda/producto/**")
                        .uri("http://localhost:8082"))

                .build();
    }
}