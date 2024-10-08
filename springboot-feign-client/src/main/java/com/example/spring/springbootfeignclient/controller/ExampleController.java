package com.example.spring.springbootfeignclient.controller;

import com.example.spring.springbootfeignclient.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feign")
public class ExampleController {
    private final ExampleService exampleService;

    @GetMapping("/data/{id}")
    public String getData(@PathVariable Long id) {
        return exampleService.getDataById(id);
    }
}
