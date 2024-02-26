package com.example.weatherapp.data.remote

import com.example.weatherapp.data.models.weather_model.WeatherDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.WeatherDayInHoursDataModel
import com.example.weatherapp.data.utils.Constants.GET_CURRENT_WEATHER_DAIS_AND_HOURS
import com.example.weatherapp.data.utils.Constants.GET_CURRENT_WEATHER_DATA
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(GET_CURRENT_WEATHER_DATA)
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ): Response<WeatherDataModel>

    @GET(GET_CURRENT_WEATHER_DAIS_AND_HOURS)
    suspend fun getCurrentWeatherDayInHours(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ): Response<WeatherDayInHoursDataModel>
}

