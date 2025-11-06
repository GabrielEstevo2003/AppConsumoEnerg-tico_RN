package com.example.demo.Controllers;

import com.example.demo.DTOs.OpenWeatherDTO;
import com.example.demo.Services.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("previsao")
public class OpenWeatherController {
    @Autowired
    OpenWeatherService openWeatherService;

    @GetMapping("/{city}")
    public OpenWeatherDTO getTemp(@PathVariable String city){
        return openWeatherService.getWeather(city);
    }
}
