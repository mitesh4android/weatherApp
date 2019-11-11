package com.example.weatherforecast.interactors;

import com.example.weatherforecast.io.APICallback;
import com.example.weatherforecast.io.APIServiceUtil;
import com.example.weatherforecast.model.WeatherInfo;

import retrofit2.Call;

public class MainInteractorImpl implements MainInteractor {
    @Override
    public void getWeatherInfo(APICallback<WeatherInfo> callback,String id, String api_key) {
        Call<WeatherInfo> callObj = APIServiceUtil.getInstance().getApiService()
                .getWeatherInfo(id, api_key);
        callObj.enqueue(callback);

    }
}
