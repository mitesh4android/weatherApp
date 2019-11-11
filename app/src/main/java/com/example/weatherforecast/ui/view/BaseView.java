package com.example.weatherforecast.ui.view;

public interface BaseView {
    /**
     * called while get error during api call
     *
     * @param error error message
     */
    void onError(String error);

    /**
     * called when there is no n/w during api call
     */
    void onNetworkError();

}
