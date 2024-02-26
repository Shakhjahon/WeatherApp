package com.example.weatherapp.presentation.models.weather_day_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherUiModelDay(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
): Serializable {
    companion object {
        val unknown = WeatherUiModelDay(
            description = "",
            icon = "",
            id = 0,
            main = ""
        )
    }
}