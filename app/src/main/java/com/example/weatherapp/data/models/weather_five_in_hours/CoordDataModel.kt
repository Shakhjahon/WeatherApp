package com.example.weatherapp.data.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName

data class CoordDataModel(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)