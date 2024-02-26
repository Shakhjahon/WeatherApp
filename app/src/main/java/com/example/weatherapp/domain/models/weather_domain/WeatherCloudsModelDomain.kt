package com.example.weatherapp.domain.models.weather_domain

import java.io.Serializable

data class WeatherCloudsModelDomain(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherCloudsModelDomain(
            all = 0,
        )
    }
}