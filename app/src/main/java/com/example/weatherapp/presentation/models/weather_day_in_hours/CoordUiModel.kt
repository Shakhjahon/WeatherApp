package com.example.weatherapp.presentation.models.weather_day_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CoordUiModel(
    val lat: Double,
    val lon: Double
): Serializable {
    companion object {
        val unknown = CoordUiModel(
            lat = 0.0,
            lon = 0.0
        )
    }
}