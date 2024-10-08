package com.example.spring.springbootfeignclient.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "exampleClient", url = "${feign-data.url}")
public interface ExampleClient {
}
