package com.example.weatherapp.presentation.models.weather

import androidx.compose.runtime.Stable
import com.example.weatherapp.data.utils.Constants.EMPTY_STRING
import java.io.Serializable

@Stable
data class WeatherUIModel(
    val coord: WeatherCoordinateModelUi,
    val weather: List<WeatherCloudModelUi>,
    val weatherBase: String,
    val weatherMain: WeatherMainModelUI,
    val visibility: Int,
    val weatherWindInfo: WeatherWindInfoModelUI,
    val weatherClouds: WeatherCloudsModelUi,
    val name: String,
    val country: CountryModelUi
) : Serializable {
    companion object {
        val unknown = WeatherUIModel(
            coord = WeatherCoordinateModelUi.unknown,
            weather = listOf(),
            weatherBase = EMPTY_STRING,
            weatherClouds = WeatherCloudsModelUi.unknown,
            weatherMain = WeatherMainModelUI.unknown,
            weatherWindInfo = WeatherWindInfoModelUI.unknown,
            visibility = 0,
            name = "Uzgen",
            country = CountryModelUi.unknown
        )
    }
}



