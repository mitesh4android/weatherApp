package com.example.weatherforecast.presenter;

import android.content.Context;

import com.example.weatherforecast.interactors.MainInteractor;
import com.example.weatherforecast.interactors.MainInteractorImpl;
import com.example.weatherforecast.io.APICallback;
import com.example.weatherforecast.model.Weather;
import com.example.weatherforecast.model.WeatherInfo;
import com.example.weatherforecast.ui.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mView;
    private final MainInteractor mInteractor = new MainInteractorImpl();


    @Override
    public void setView(MainView view) {
        this.mView = view;
    }

    @Override
    public void fetchWeatherInfo(Context context, String id, String api_key) {
        mInteractor.getWeatherInfo(new APICallback<WeatherInfo>(context) {
            @Override
            public void onResponseSuccess(WeatherInfo response) {
                if (mView == null){
                    return;
                }
                if (response == null) {
                    mView.weatherFetchFailed();
                    return;
                }
                if(response != null ){
                    mView.weatherFetchSuccess(response);
                }else {
                    mView.weatherFetchFailed();
                }
            }

            @Override
            public void onResponseFailure(String errorMessage) {
                if (mView == null)
                    return;
                mView.onError(errorMessage);
            }
        }, id, api_key);
    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void cancelRequest(Context ctx, String tag) {

    }
}
