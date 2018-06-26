package com.example.rakib.asynchttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.rakib.asynchttp.api.ApiClient;

import com.example.rakib.asynchttp.api.WeatherApiServices;
import com.example.rakib.asynchttp.model.CityResponse;

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

        Call<CityResponse> londonCall=weatherApiServices.getWeatherDetails(API_KEY); //passing the paremeter value

        londonCall.enqueue(new Callback<CityResponse>() {

            //Auto created
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {

                //Todo: On Success Taks should be right there
                Log.d("Tareq", response.body().getCoord().getLon().toString());

            }

            //auto Created
            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {

                //Todo: On failure Tasks

            }
        });

    }



}
