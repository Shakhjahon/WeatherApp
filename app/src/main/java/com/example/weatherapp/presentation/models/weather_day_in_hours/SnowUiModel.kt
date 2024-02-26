package com.example.weatherapp.presentation.models.weather_day_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SnowUiModel(
    val h: Double
) : Serializable {
    companion object {
        val unknown = SnowUiModel(
            h = 0.0
        )
    }
}