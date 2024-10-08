package com.example.spring.springbootfeignclient.controller;

import com.example.spring.springbootfeignclient.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feign")
public class ExampleController {
    private final ExampleService exampleService;

    @GetMapping("/data/{id}")
    public String getData(@PathVariable Long id) {
        return exampleService.getDataById(id);
    }

    @PostMapping("/data")
    public String createData(@RequestParam String name, @RequestParam int value) {
        return exampleService.createData(name, value);
    }

    @PutMapping("/data/{id}")
    public String updateData(@PathVariable Long id, @RequestParam String name, @RequestParam int value) {
        return exampleService.updateData(id, name, value);
    }

    @DeleteMapping("/data/{id}")
    public String deleteData(@PathVariable Long id) {
        return exampleService.deleteData(id);
    }

}
