package com.example.weatherforecast.io;

import com.example.weatherforecast.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("data/2.5/weather")
    Call<WeatherInfo> getWeatherInfo(@Query("id") String id, @Query("appid") String app_id);


}
