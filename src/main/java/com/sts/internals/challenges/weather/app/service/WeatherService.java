package com.sts.internals.challenges.weather.app.service;


import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.LinkedHashMap;

@Service
public class WeatherService {
    public static final String api_key = "0403f631daf8ca0e022636ee2fd0e193";
    private ReactiveMongoTemplate template;
    private final String directGeocoder="http://api.openweathermap.org/geo/1.0/direct";
    private final String uriAirpollutionCurrent="http://api.openweathermap.org/data/2.5/air_pollution";
    private final String uriAirpollutionForecast="http://api.openweathermap.org/data/2.5/air_pollution/forecast";
    private final String uriWeatherForecasting ="http://api.openweathermap.org/data/2.5/forecast";
    RestTemplate restTemplate=new RestTemplate();
    public WeatherService() {
    }

    public WeatherService(ReactiveMongoTemplate template) {
        this.template = template;
    }

    public String getWeatherPredictionByCityName(String city){

        UriComponentsBuilder builder=UriComponentsBuilder.fromUri(URI.create(uriWeatherForecasting))
                .queryParam("q",city)
                .queryParam("appid", api_key);

        return restTemplate.getForObject(builder.buildAndExpand().toUri(),String.class);

    }
    public String getGeoCoordinatesByCityName(String city){

        UriComponentsBuilder builder=UriComponentsBuilder.fromUri(URI.create(directGeocoder))
                .queryParam("q",city)
                .queryParam("appid", api_key)
                .queryParam("limit",1);

        return restTemplate.getForObject(builder.buildAndExpand().toUri(),String.class);
    }

    public String getCurrentAirpollution(String city) throws ParseException {
        Coordinates coordinates=getCoordinatesByCity(city);
        UriComponentsBuilder builder=UriComponentsBuilder.fromUri(URI.create(uriAirpollutionCurrent))
                .queryParam("lat",coordinates.getLatitude())
                .queryParam("lon",coordinates.getLongitude())
                .queryParam("appid", api_key);

        return restTemplate.getForObject(builder.buildAndExpand().toUri(),String.class);
    }
    private Coordinates getCoordinatesByCity(String city) throws ParseException {
        String encoderResponse= getGeoCoordinatesByCityName(city);
        // parse and save in coordinates object

        JSONParser jsonParser = new JSONParser(encoderResponse.substring(1,encoderResponse.length()-1));
        LinkedHashMap<String, Object> responseMap = jsonParser.parseObject();
        Coordinates coordinates=new Coordinates();
        coordinates.setLatitude(responseMap.get("lat").toString());
        coordinates.setLongitude(responseMap.get("lon").toString());
        return coordinates;

    }




}
