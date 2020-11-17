package com.abc.myweather.Retrofit;


import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    String temp;

    @SerializedName("feels_like")
    String feels_like;

    @SerializedName("temp_min")
    String temp_min;

    @SerializedName("temp_max")
    String temp_max;

    @SerializedName("humidity")
    String humidity;

    @SerializedName("pressure")
    String pressure;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @SerializedName("wind")
    String wind;

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @SerializedName("main")
    String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

}

