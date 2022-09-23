package com.sts.internals.challenges.weather.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class AirComposition {
    private Long dt;
    @JsonProperty
    private String main;
    @JsonProperty
    private String components;
}
