package com.example.weatherapp.presentation.models.weather_day_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SysUiModel(
    val pod: String
) : Serializable {
    companion object {
        val unknown = SysUiModel(
            pod = ""
        )
    }
}