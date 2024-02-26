package com.example.weatherapp.domain.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName

data class WeatherDomainModel(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)