package com.example.weatherapp.domain.models.weather_domain

import java.io.Serializable

data class WeatherWindInfoModelDomain(
    val weatherSpeed: Int,
    val weatherDag: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoModelDomain(
            weatherDag = 0,
            weatherSpeed = 0
        )
    }
}
