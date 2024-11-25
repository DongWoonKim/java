package com.example.spring.webfrontadminservice.service;

import com.example.spring.webfrontadminservice.dto.CreateCatalogRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final RabbitTemplate rabbitTemplate;
    public static final String EXCHANGE_NAME = "polar.admin";
    public static final String ROUTING_KEY = "catalog.create";

    public void createCatalog(CreateCatalogRequestDTO createCatalogRequestDTO) {
        rabbitTemplate
                .convertAndSend(
                        EXCHANGE_NAME,
                        ROUTING_KEY,
                        createCatalogRequestDTO
                );
    }

}
