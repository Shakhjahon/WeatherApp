package com.example.weatherapp.presentation.models.weather

import java.io.Serializable

data class WeatherCoordinateModelUi(
     val longitude: Double,
     val latitude: Double,
): Serializable {
    companion object {
        val unknown = WeatherCoordinateModelUi(
            longitude = 0.0,
            latitude = 0.0
        )
    }
}

