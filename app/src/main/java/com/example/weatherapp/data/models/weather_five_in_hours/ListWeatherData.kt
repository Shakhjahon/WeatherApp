package com.example.weatherapp.data.models.weather_five_in_hours

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ListWeatherData (
    @SerializedName("clouds")
    val clouds: CloudsDataModel,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val main: MainDataModel,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("snow")
    val snow: SnowDataModel?,
    @SerializedName("sys")
    val sys: SysDataModel,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<WeatherDataModel>,
    @SerializedName("wind")
    val wind: WindDataModel
) : Serializable