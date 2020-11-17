package com.abc.myweather;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.abc.myweather.Retrofit.ApiClient;
import com.abc.myweather.Retrofit.ApiInterface;
import com.abc.myweather.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView search;
    TextView cityText,tempText, climateText, descText,minText, maxText, windText, humText, pressureText;
    EditText cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        cityName = findViewById(R.id.cityName);
        cityText = findViewById(R.id.cityText);
        tempText = findViewById(R.id.tempText);
        climateText = findViewById(R.id.climateText);
        descText = findViewById(R.id.descText);
        minText = findViewById(R.id.minText);
        maxText = findViewById(R.id.maxText);
        windText = findViewById(R.id.windText);
        humText = findViewById(R.id.humText);
        pressureText = findViewById(R.id.pressureText);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call API
                getWeatherData(cityName.getText().toString().trim());

            }
        });
    }

    private void getWeatherData(String name){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                cityText.setText(cityName.getText().toString().trim().toUpperCase());
                cityName.getText().clear();
                tempText.setText((int)(Double.parseDouble(response.body().getMain().getTemp())-273.15)+" °C");
                climateText.setText(response.body().getMain().getMain());
                descText.setText("Feels like"+" "+(int)(Double.parseDouble(response.body().getMain().getFeels_like())-273.15)+" °C");
                minText.setText("Min Temp"+" "+(int)(Double.parseDouble(response.body().getMain().getTemp_min())-273.15)+" °C");
                maxText.setText("Max Temp"+" "+(int)(Double.parseDouble(response.body().getMain().getTemp_max())-273.15)+" °C");
                windText.setText(response.body().getMain().getWind());
                humText.setText("Humidity"+" "+response.body().getMain().getHumidity()+" %");
                pressureText.setText("Pressure"+" "+response.body().getMain().getPressure()+" mb");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

}
