package com.example.weatherapp.data.models.weather_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherCloudsModel(
    @SerializedName("all") val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherCloudsModel(
            all = 0,
        )
    }
}