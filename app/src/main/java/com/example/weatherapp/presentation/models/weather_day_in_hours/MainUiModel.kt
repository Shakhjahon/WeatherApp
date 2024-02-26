package com.example.weatherapp.presentation.models.weather_day_in_hours


import java.io.Serializable

data class MainUiModel(
    val feelsLike: Double,
    val grndLevel: Int,
    val humidity: Int,
    val pressure: Int,
    val seaLevel: Int,
    val temp: Double,
    val tempKf: Double,
    val tempMax: Double,
    val tempMin: Double
) : Serializable {
    companion object {
        val unknown = MainUiModel(
            feelsLike = 277.63,
            temp = 277.63,
            tempMax = 277.63,
            tempMin = 277.63,
            pressure = 1025,
            seaLevel = 1025,
            grndLevel = 906,
            humidity = 56,
            tempKf = 0.0
        )
    }
}