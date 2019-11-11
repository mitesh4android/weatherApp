package com.example.weatherforecast.ui.view;

import com.example.weatherforecast.model.WeatherInfo;

public interface MainView extends BaseView {

    /**
     * called when Weather fetched successfully
     *
     * @param weatherInfo WeatherInfo
     */
    void weatherFetchSuccess(WeatherInfo weatherInfo);

    /**
     * called when Weather fetched failed
     */
    void weatherFetchFailed();

}
