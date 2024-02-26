package com.example.weatherapp.presentation.models.weather

import java.io.Serializable

data class WeatherWindInfoModelUI(
    val weatherSpeed: Int,
    val weatherDag: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoModelUI(
            weatherDag = 0,
            weatherSpeed = 0
        )
    }
}
