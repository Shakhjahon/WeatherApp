package com.example.weatherapp.presentation.models.weather

import java.io.Serializable

data class WeatherCloudsModelUi(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherCloudsModelUi(
            all = 0,
        )
    }
}