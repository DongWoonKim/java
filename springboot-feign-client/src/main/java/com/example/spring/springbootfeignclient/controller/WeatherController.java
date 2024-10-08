package com.example.spring.springbootfeignclient.controller;

import com.example.spring.springbootfeignclient.dto.weather.WeatherResponse;
import com.example.spring.springbootfeignclient.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponse getWeatherData() {
        return weatherService.getWeatherData();
    }

}
