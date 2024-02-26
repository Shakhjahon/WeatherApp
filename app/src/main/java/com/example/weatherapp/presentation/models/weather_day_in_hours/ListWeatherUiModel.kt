package com.example.weatherapp.presentation.models.weather_day_in_hours

import java.io.Serializable


data class ListWeatherUiModel(
    val clouds: CloudsUiModel,
    val dt: Int,
    val dtTxt: String,
    val main: MainUiModel,
    val pop: Double,
    val snow: SnowUiModel?,
    val sys: SysUiModel,
    val visibility: Int,
    val weather: List<WeatherUiModelDay>,
    val wind: WindUiModel
) : Serializable {
    companion object {
        val unknown = ListWeatherUiModel(
            clouds = CloudsUiModel.unknown,
            dt = 0,
            dtTxt = "",
            main = MainUiModel.unknown,
            pop = 0.0,
            snow = SnowUiModel.unknown,
            sys = SysUiModel.unknown,
            visibility = 0,
            weather = listOf(),
            wind = WindUiModel.unknown
        )
    }
}