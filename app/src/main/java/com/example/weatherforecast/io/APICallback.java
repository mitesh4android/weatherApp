package com.example.weatherforecast.io;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class APICallback<T> implements Callback<T> {

    private final Context mContext;

    /**
     * Constructor
     *
     * @param ctx context
     */
    public APICallback(Context ctx) {
        mContext = ctx;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onResponseSuccess(response.body());
        } else {
            // Refresh token failure case handling
            if (response.errorBody() != null) {
                try {
                    JSONObject jObjError =
                            new JSONObject(Objects.requireNonNull(response.errorBody()).string());
                    onResponseFailure(jObjError.getString("message"));
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                onResponseFailure(response.message());
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onResponseFailure(t.getMessage());
    }

    /**
     * Method to be called when response is success
     *
     * @param response response
     */
    protected abstract void onResponseSuccess(T response);

    /**
     * Method to be called when response is success
     *
     * @param errorMessage error message
     */
    protected abstract void onResponseFailure(String errorMessage);


}
