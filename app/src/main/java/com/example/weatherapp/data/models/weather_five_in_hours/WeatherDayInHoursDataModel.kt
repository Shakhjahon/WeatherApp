package com.example.weatherapp.data.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDayInHoursDataModel(
    @SerializedName("city")
    val city: CityDataModel,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<ListWeatherData>,
    @SerializedName("message")
    val message: Int
) : Serializable