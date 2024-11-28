package com.example.spring.webfrontservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "authClient", url = "${polar.auth-service-url}")
public interface AuthClient {
}
