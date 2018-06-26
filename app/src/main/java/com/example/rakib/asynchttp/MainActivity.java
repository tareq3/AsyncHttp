package com.example.rakib.asynchttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.rakib.asynchttp.api.ApiClient;

import com.example.rakib.asynchttp.api.WeatherApiServices;
import com.example.rakib.asynchttp.model.London;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    //Todo: Store the Api key right here
    private final static String API_KEY="7546c1b03b96db7a7aad6f3e05e9ee81";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherApiServices weatherApiServices= ApiClient.getClient().create(WeatherApiServices.class);

        Call<London> londonCall=weatherApiServices.getWeatherDetails(API_KEY);

        londonCall.enqueue(new Callback<London>() {
            @Override
            public void onResponse(Call<London> call, Response<London> response) {
                Log.d("Tareq", response.body().getCoord().getLon().toString());
            }

            @Override
            public void onFailure(Call<London> call, Throwable t) {

            }
        });

    }



}
