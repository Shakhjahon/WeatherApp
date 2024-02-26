package com.example.weatherapp.data.models.weather_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherMainModel(
    @SerializedName("temp")
    val weatherTemperature: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val weatherMinTemp: Double,
    @SerializedName("temp_max")
    val weatherMaxTemp: Double,
    @SerializedName("pressure")
    val weatherPressure: Int,
    @SerializedName("humidity")
    val weatherHumidity: Int,
) : Serializable {
    companion object {
        val unknown = WeatherMainModel(
            weatherHumidity = 0,
            weatherMaxTemp = 0.0,
            weatherMinTemp = 0.0,
            weatherPressure = 0,
            weatherTemperature = 0.0,
            feelsLike = 0.0
        )
    }
}
