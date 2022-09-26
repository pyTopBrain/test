package com.sts.internals.challenges.weather.app.repository;


import com.sts.internals.challenges.weather.app.model.Coordinates;
import com.sts.internals.challenges.weather.app.model.WeatherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Service
public class WeatherService {
    private ReactiveMongoTemplate template;

    public WeatherService() {
    }

    public WeatherService(ReactiveMongoTemplate template) {
        this.template = template;
    }



    public WeatherDetails createWeatherDetail(Coordinates coordinates){

        return null;
    }
    /*HttpClient httpClient = HttpClient.create()
            .resolver(spec -> spec.queryTimeout(Duration.ofSeconds(100)));
*/
    @Autowired
    WebClient client ;//= WebClient.builder()
    //        .clientConnector(new ReactorClientHttpConnector(httpClient))
            //.build();
    public Mono<Object> retrieveWeatherDetail(Coordinates coordinates){
      String uri="http://api.openweathermap.org/data/2.5/air_pollution/forecast";


        Mono<Object> weatherDetailsFlux = client
                .get()
                .uri(uriBuilder -> uriBuilder.path(uri)
                        .queryParam("lat",coordinates.getLatitude())
                        .queryParam("lon",coordinates.getLongitude())
                        .queryParam("appid","0403f631daf8ca0e022636ee2fd0e193")
                        .build())
                .retrieve()
                .bodyToMono(Object.class);
                return weatherDetailsFlux;
    }
}
