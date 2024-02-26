package com.example.weatherapp.presentation.models.weather

import java.io.Serializable

data class WeatherMainModelUI(
    val weatherTemperature: Double,
    val feelsLike: Double,
    val weatherMinTemp: Double,
    val weatherMaxTemp: Double,
    val weatherPressure: Int,
    val weatherHumidity: Int,
) : Serializable {
    companion object {
        val unknown = WeatherMainModelUI(
            weatherHumidity = 0,
            weatherMaxTemp = 0.0,
            weatherMinTemp = 0.0,
            weatherPressure = 0,
            weatherTemperature = 0.0,
            feelsLike = 0.0
        )
    }
}
