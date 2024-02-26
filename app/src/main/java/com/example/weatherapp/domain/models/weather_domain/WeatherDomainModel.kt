package com.example.weatherapp.domain.models.weather_domain

import com.example.weatherapp.data.utils.Constants.EMPTY_STRING
import java.io.Serializable

data class WeatherDomainModel(
    val coord: WeatherCoordinateModelDomain,
    val weather: List<WeatherCloudModelDomain>,
    val weatherBase: String,
    val weatherMain: WeatherMainModelDomain,
    val visibility: Int,
    val weatherWindInfo: WeatherWindInfoModelDomain,
    val weatherClouds: WeatherCloudsModelDomain,
    val name: String,
    val country: CountryModelDomain,
) : Serializable {
    companion object {
        val unknown = WeatherDomainModel(
            coord = WeatherCoordinateModelDomain.unknown,
            weather = listOf(WeatherCloudModelDomain.unknown),
            weatherBase = "stations",
            weatherClouds = WeatherCloudsModelDomain.unknown,
            weatherMain = WeatherMainModelDomain.unknown,
            weatherWindInfo = WeatherWindInfoModelDomain.unknown,
            visibility = 0,
            name = EMPTY_STRING,
            country = CountryModelDomain.unknown
        )
    }
}

data class CountryModelDomain(
    val countryModel: String,
) : Serializable {
    companion object {
        val unknown = CountryModelDomain(
            countryModel = ""
        )
    }
}

