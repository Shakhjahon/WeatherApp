package com.example.weatherapp.data.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SysDataModel(
    @SerializedName("pod")
    val pod: String
) : Serializable