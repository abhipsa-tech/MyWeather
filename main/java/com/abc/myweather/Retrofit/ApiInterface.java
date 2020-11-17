package com.abc.myweather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?&appid=956579807dd8928989fe3fc1b4b53edb")
    Call<Example> getWeatherData(@Query("q") String name);
}
