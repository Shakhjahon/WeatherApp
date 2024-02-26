package com.example.weatherapp.domain.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CityDomainModel(
    @SerializedName("coord")
    val coord: CoordDomainModel,
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
) : Serializable {
    companion object {
        val unknown = CityDomainModel(
            coord = CoordDomainModel.unknown,
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