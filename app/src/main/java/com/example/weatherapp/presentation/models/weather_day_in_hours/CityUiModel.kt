package com.example.weatherapp.presentation.models.weather_day_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CityUiModel(
    val coord: CoordUiModel,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
) : Serializable {
    companion object {
        val unknown = CityUiModel(
            coord = CoordUiModel.unknown,
            country = "",
            id = 0,
            name = "",
            population = 0,
            sunrise = 0,
            sunset = 0,
            timezone = 0,
        )
    }
}