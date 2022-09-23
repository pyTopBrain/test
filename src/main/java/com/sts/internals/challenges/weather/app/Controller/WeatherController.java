package com.sts.internals.challenges.weather.app.Controller;

import com.sts.internals.challenges.weather.app.model.Coordinates;
import com.sts.internals.challenges.weather.app.model.WeatherDetails;
import com.sts.internals.challenges.weather.app.repository.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping
    public Mono<WeatherDetails> weather(
                                         @RequestBody Coordinates coordinates){
        return service.retrieveWeatherDetail(coordinates);
    }

}
