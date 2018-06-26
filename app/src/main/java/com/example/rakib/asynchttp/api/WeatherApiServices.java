package com.example.rakib.asynchttp.api;

import com.example.rakib.asynchttp.model.CityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiServices {

    @GET("/data/2.5/weather?id=2172797")
    Call<CityResponse> getWeatherDetails(@Query("APPID") String apiKey);

    //region Hints for retrofit calls
/*    So, using this route the retrofit will generate the following URL:
    http://api.themoviedb.org/3/movie/top_rated?api_key=12345678910111213

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    //for variable in path
      @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);


    HERE are some example of annotation in retrofit2:
      Take a look to other annotations:

@Path – variable substitution for the API endpoint. For example movie id will be swapped for{id} in the URL endpoint.

@Query – specifies the query key name with the value of the annotated parameter.

@Body – payload for the POST call

@Header – specifies the header with the value of the annotated parameter
    */
    //endregion

}
