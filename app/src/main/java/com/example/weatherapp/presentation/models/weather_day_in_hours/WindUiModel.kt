package com.example.weatherapp.presentation.models.weather_day_in_hours


import java.io.Serializable

data class WindUiModel(
    val deg: Int,
    val gust: Double,
    val speed: Double
) : Serializable {
    companion object {
        val unknown = WindUiModel(
            deg = 0,
            gust = 0.0,
            speed = 0.0
        )
    }
}