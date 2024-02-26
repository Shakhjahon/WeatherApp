package com.example.weatherapp.data.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SnowDataModel(
    @SerializedName("3h")
    val h: Double
) : Serializable