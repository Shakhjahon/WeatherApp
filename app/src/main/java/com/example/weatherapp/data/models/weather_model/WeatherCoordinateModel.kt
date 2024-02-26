package com.example.weatherapp.data.models.weather_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherCoordinateModel(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
) : Serializable {
    companion object {
        val unknown = WeatherCoordinateModel(
            longitude = 0.0,
            latitude = 0.0
        )
    }
}

