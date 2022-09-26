package com.sts.internals.challenges.weather.app.Controller;

import com.sts.internals.challenges.weather.app.model.Coordinates;
import com.sts.internals.challenges.weather.app.repository.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    WebClient.Builder client;

    RestTemplate restTemplate=new RestTemplate();

//    @PostMapping
//    public Mono<Object> weather(@RequestBody Coordinates coordinates){
//        return service.retrieveWeatherDetail(coordinates);
//    }

    @GetMapping("/template")
    public Object getByRestTample(@RequestBody Coordinates coordinates){
        String uri="http://api.openweathermap.org/data/2.5/air_pollution/forecast";
        UriComponentsBuilder builder=UriComponentsBuilder.fromUri(URI.create(uri))
                .queryParam("lat",40)
                .queryParam("lon",50)
                .queryParam("appid","0403f631daf8ca0e022636ee2fd0e193");

        return restTemplate.getForObject(builder.buildAndExpand().toUri(),Object.class);

    }


    @GetMapping
    public Object getWeather(@RequestBody Coordinates coordinates){
        String uri="http://api.openweathermap.org/data/2.5/air_pollution/forecast";
        return client.build()
                .get()
                .uri(uriBuilder -> uriBuilder.path(uri)
                        .queryParam("lat",50)
                        .queryParam("lon",50)
                        .queryParam("appid","0403f631daf8ca0e022636ee2fd0e193")
                        .build())
                .retrieve()
                .bodyToMono(Object.class).block();
    }

}
