package com.example.weatherapp.domain.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName

data class WindDomainModel(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double,
    @SerializedName("speed")
    val speed: Double
)