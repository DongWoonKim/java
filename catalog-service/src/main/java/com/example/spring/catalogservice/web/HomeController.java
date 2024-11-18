package com.example.spring.catalogservice.web;

import com.example.spring.catalogservice.config.PolarProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final PolarProperties polarProperties;

    @GetMapping("/")
    public String greeting() {
        return polarProperties.getGreeting();
    }

}
