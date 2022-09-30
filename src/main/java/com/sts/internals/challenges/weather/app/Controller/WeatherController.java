package com.sts.internals.challenges.weather.app.Controller;

import com.sts.internals.challenges.weather.app.service.WeatherService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/prediction")
    public String getWeatherPredictionByCityName(@RequestParam String city){
        return service.getWeatherPredictionByCityName(city);

    }


    @GetMapping("/geo-encoding")
    public String getWeather(@RequestParam String city){
         return service.getGeoCoordinatesByCityName(city);
    }
    @GetMapping("/air-pollution")
    public String getCurrentAirPollution(@RequestParam String city) throws ParseException {
        return service.getCurrentAirpollution(city);
    }

}
