package com.example.weatherapp.domain.models.weather_domain

import java.io.Serializable

data class WeatherMainModelDomain(
    val weatherTemperature: Double,
    val feelsLike: Double,
    val weatherMinTemp: Double,
    val weatherMaxTemp: Double,
    val weatherPressure: Int,
    val weatherHumidity: Int,
) : Serializable {
    companion object {
        val unknown = WeatherMainModelDomain(
            weatherHumidity = 0,
            weatherMaxTemp = 0.0,
            weatherMinTemp = 0.0,
            weatherPressure = 0,
            weatherTemperature = 0.0,
            feelsLike = 0.0
        )
    }
}
