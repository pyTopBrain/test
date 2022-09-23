package com.sts.internals.challenges.weather.app.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document
public class AirPollution {
    @DocumentReference
    private List<AirComposition> airCompositions;
}
