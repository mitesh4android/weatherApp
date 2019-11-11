package com.example.weatherforecast.presenter;

import android.content.Context;

public interface BasePresenter {

    /**
     * Called to clean/garbage resource which is not in used
     */
    void onDestroy();

    /**
     * Called to cancel ongoing network request
     *
     * @param ctx context
     * @param tag tag
     */
    void cancelRequest(Context ctx, String tag);

}
