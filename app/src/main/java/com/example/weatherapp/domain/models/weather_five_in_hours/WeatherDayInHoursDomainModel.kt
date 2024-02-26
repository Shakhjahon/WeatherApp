package com.example.weatherapp.domain.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDayInHoursDomainModel(
    @SerializedName("city")
    val city: CityDomainModel,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<ListWeatherDomain>,
    @SerializedName("message")
    val message: Int
) : Serializable{
    companion object{
        val unknown = WeatherDayInHoursDomainModel(
            city = CityDomainModel.unknown,
            cnt = 0,
            cod = "",
            list = listOf(),
            message = 0
        )
    }
}