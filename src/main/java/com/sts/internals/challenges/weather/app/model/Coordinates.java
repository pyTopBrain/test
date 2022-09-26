package com.sts.internals.challenges.weather.app.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Coordinates implements Serializable {
    private String latitude;
    private String longitude;

}
