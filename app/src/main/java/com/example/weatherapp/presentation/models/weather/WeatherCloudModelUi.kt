package com.example.weatherapp.presentation.models.weather

import com.example.weatherapp.data.utils.Constants.EMPTY_STRING

data class WeatherCloudModelUi(
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
) {
    val isClouds = weatherMain == "Clouds"

    val isRain = weatherMain == "Rain"

    val isSunny = weatherMain == "Sunny"

    val isSmoke = weatherMain == "Smoke" || weatherMain == "Mist" || weatherMain == "Fog"

    companion object {
        val unknown = WeatherCloudModelUi(
            weatherMain = EMPTY_STRING,
            weatherId = 0,
            weatherDescription = EMPTY_STRING
        )
    }
}










