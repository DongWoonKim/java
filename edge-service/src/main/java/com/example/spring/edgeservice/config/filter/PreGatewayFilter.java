package com.example.spring.edgeservice.config.filter;

import com.example.spring.edgeservice.config.client.AuthServiceClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Order(0)
@Component
@RequiredArgsConstructor
public class PreGatewayFilter extends AbstractGatewayFilterFactory<PreGatewayFilter.Config> {

    private final AuthServiceClient authServiceClient;

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            log.info("token: {}", token);

            // 토큰 유효성 검사
            if (token != null && token.startsWith(config.getTokenPrefix())) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return authServiceClient.validToken(token)
                    .flatMap(statusNum -> {
                        if (statusNum == 2) {

                        } else if (statusNum == 3 || statusNum == -1) {

                        }

                        return chain.filter(exchange);
                    })
                    .onErrorResume(e -> {
                        log.error("token filter error: {}", e.getMessage());
                        exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                        return exchange.getResponse().setComplete();
                    });
        };
    }

    @Getter
    @Setter
    public static class Config {
        private String tokenPrefix = "Bearer ";
        private int authenticationTimeoutCode = 419;
    }
}
