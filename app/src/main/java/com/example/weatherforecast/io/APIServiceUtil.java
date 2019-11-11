package com.example.weatherforecast.io;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceUtil {
    private static final APIServiceUtil INSTANCE = new APIServiceUtil();
    private final String ACCEPT_KEY = "Accept";
    private final String ACCEPT_VALUE = "application/json";
    private final Retrofit mRetrofit;


    /**
     * Method to initialize api client
     */
    private APIServiceUtil() {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//        File httpCacheDirectory = new File(httpLoggingInterceptor.tCacheDir(), "offlineCache");
//
//        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();

//                        Request.Builder builder = request.newBuilder()
//                                .header("Cache-Control", "public, only-if-cached, max-stale=" +  0);
//
//                        return chain.proceed(builder.build());
                        return chain.proceed(request);

                    }
                }).build();

        mRetrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static APIServiceUtil getInstance() {
        return INSTANCE;
    }

    /**
     * Method to get api interface instance
     *
     * @return api interface
     */
    public APIService getApiService() {
        return mRetrofit.create(APIService.class);
    }



}

