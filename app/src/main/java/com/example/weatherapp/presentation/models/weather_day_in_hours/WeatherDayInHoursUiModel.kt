package com.example.weatherapp.presentation.models.weather_day_in_hours


import java.io.Serializable

data class WeatherDayInHoursUiModel(
    val city: CityUiModel,
    val cnt: Int,
    val cod: String,
    val list: List<ListWeatherUiModel>,
    val message: Int
) : Serializable {
    companion object {
        val unknown = WeatherDayInHoursUiModel(
            city = CityUiModel.unknown,
            cnt = 0,
            cod = "",
            list = listOf(),
            message = 0
        )
    }
}