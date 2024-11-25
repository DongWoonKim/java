package com.example.spring.webfrontadminservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/catalog")
public class CatalogController {

    @GetMapping
    public String createCatalog() {
        return "create-catalog";
    }

}
