package com.example.weatherforecast.interactors;

import com.example.weatherforecast.io.APICallback;
import com.example.weatherforecast.model.WeatherInfo;

public interface MainInteractor {
    /**
     * called to fetch Facility Category data
     *
     * @param callback api callback
     */
    void getWeatherInfo(APICallback<WeatherInfo> callback, String id, String api_key);


}
