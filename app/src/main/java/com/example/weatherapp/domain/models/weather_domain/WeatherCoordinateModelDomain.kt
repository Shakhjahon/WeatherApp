package com.example.weatherapp.domain.models.weather_domain

import java.io.Serializable

data class WeatherCoordinateModelDomain(
     val longitude: Double,
     val latitude: Double,
): Serializable {
    companion object {
        val unknown = WeatherCoordinateModelDomain(
            longitude = 0.0,
            latitude = 0.0
        )
    }
}

