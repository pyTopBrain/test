package com.sts.internals.challenges.weather.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientConfiguration{
    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
    }