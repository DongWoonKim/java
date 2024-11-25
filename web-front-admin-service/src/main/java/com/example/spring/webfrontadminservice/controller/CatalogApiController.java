package com.example.spring.webfrontadminservice.controller;

import com.example.spring.webfrontadminservice.dto.CreateCatalogRequestDTO;
import com.example.spring.webfrontadminservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/api/catalog")
public class CatalogApiController {

    private final CatalogService catalogService;

    @PostMapping
    public ResponseEntity<Void> createCatalog(@RequestBody CreateCatalogRequestDTO createCatalogRequestDTO) {
        catalogService.createCatalog(createCatalogRequestDTO);
        return ResponseEntity.ok().build();
    }

}
