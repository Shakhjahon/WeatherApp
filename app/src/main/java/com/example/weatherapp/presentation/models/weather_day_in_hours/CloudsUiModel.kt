package com.example.weatherapp.presentation.models.weather_day_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CloudsUiModel(
    val all: Int
) : Serializable{
    companion object {
        val unknown = CloudsUiModel(
            all = 0
        )
    }
}