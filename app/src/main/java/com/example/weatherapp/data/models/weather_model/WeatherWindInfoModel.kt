package com.example.weatherapp.data.models.weather_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherWindInfoModel(
    @SerializedName("speed") val weatherSpeed: Int,
    @SerializedName("deg") val weatherDag: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoModel(
            weatherDag = 0,
            weatherSpeed = 0
        )
    }
}
