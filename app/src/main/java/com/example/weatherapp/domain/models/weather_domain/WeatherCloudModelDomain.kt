package com.example.weatherapp.domain.models.weather_domain

import java.io.Serializable

data class WeatherCloudModelDomain(
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
) : Serializable {
    companion object {
        val unknown = WeatherCloudModelDomain(
            weatherId = 711,
            weatherDescription = "Rain",
            weatherMain = "rain"
        )
    }
}







