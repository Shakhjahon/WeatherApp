package com.example.weatherapp.data.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CityDataModel(
    @SerializedName("coord")
    val coord: CoordDataModel,
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int,
    @SerializedName("timezone")
    val timezone: Int
) : Serializable