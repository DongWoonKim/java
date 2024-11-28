package com.example.spring.edgeservice.config.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class PreGatewayFilter extends AbstractGatewayFilterFactory<PreGatewayFilter.Config> {



    public PreGatewayFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    @Getter
    @Setter
    public static class Config {
        private String tokenPrefix = "Bearer ";
        private int authenticationTimeoutCode = 419;
    }
}
