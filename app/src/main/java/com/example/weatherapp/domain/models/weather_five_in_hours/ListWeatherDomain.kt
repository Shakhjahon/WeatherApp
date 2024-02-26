package com.example.weatherapp.domain.models.weather_five_in_hours


data class ListWeatherDomain(
    val clouds: CloudsDomainModel,
    val dt: Int,
    val dtTxt: String,
    val main: MainDomainModel,
    val pop: Double,
    val snow: SnowDomainModel?,
    val sys: SysDomainModel,
    val visibility: Int,
    val weather: List<WeatherDomainModel>,
    val wind: WindDomainModel
)