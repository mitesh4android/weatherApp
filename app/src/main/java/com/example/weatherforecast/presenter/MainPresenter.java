package com.example.weatherforecast.presenter;

import android.content.Context;

import com.example.weatherforecast.ui.view.MainView;

public interface MainPresenter extends BasePresenter {

    /**
     * set view of screen
     *
     * @param view view
     */
    void setView(MainView view);


    /**
     * Method to fetch Facility Category API for Home Page data
     *
     * @param context context
     */

    void fetchWeatherInfo(Context context, String id, String api_key);


}
