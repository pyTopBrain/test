package com.sts.internals.challenges.weather.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Document
public class WeatherDetails {
    //private CurrentWeather currentWeather;
    //private ClimaticForecast climaticForecast;
   @DocumentReference
    private AirPollution airPollution;
    //private UVIndex uvIndex;

}
