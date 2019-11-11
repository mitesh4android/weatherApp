package com.example.weatherforecast.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherforecast.R;
import com.example.weatherforecast.model.WeatherInfo;
import com.example.weatherforecast.presenter.MainPresenter;
import com.example.weatherforecast.presenter.MainPresenterImpl;
import com.example.weatherforecast.ui.view.MainView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements MainView {

    public static String id = "7778677";
    public static String appid = "5ad7218f2e11df834b0eaf3a33a39d2a";

    private final MainPresenter mPresenter = new MainPresenterImpl();

    TextView txt_location, txt_temp, txt_humidity, txt_main, txt_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.setView(this);
        initViews();
        mPresenter.fetchWeatherInfo(MainActivity.this, id, appid);
    }

    private void initViews() {
        txt_location = findViewById(R.id.txt_location);
        txt_temp = findViewById(R.id.txt_temp);
        txt_humidity = findViewById(R.id.txt_humidity);
        txt_main = findViewById(R.id.txt_main);
        txt_desc = findViewById(R.id.txt_desc);

    }


    @Override
    public void weatherFetchSuccess(WeatherInfo weatherInfo) {

        if(weatherInfo.name != null){
            txt_location.setText(weatherInfo.name);
        }

        if(weatherInfo.main != null){
            txt_temp.setText(weatherInfo.main.temp+"f");
            txt_humidity.setText(weatherInfo.main.humidity+"");
        }

        if(weatherInfo.weather != null && weatherInfo.weather.size() > 0){
            txt_main.setText(weatherInfo.weather.get(0).main);
            txt_desc.setText(weatherInfo.weather.get(0).description);
        }
    }

    @Override
    public void weatherFetchFailed() {
        Toast.makeText(this, R.string.error_unable_to_get_response, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNetworkError() {
        Toast.makeText(this, R.string.error_network_unavailable, Toast.LENGTH_LONG).show();
    }
}
