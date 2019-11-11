package com.example.weatherforecast.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherInfo {

    @SerializedName("coord")
    public Coord coord;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("weather")
    public ArrayList<Weather> weather = new ArrayList<Weather>();
    @SerializedName("base")
    public String base;
    @SerializedName("main")
    public Main main;
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("rain")
    public Rain rain;
    @SerializedName("clouds")
    public Clouds clouds;
    @SerializedName("dt")
    public long dt;
    @SerializedName("timezone")
    public long timezone;
    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("cod")
    public int cod;

}
