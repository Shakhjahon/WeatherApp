package com.example.weatherapp.domain.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName

data class SysDomainModel(
    @SerializedName("pod")
    val pod: String
)