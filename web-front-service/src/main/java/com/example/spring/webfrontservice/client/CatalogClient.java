package com.example.spring.webfrontservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "catalogClient", url = "${polar.catalog-service-url}")
public interface CatalogClient {
}
