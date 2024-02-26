package com.example.weatherapp.domain.models.weather_five_in_hours


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CoordDomainModel(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
): Serializable {
    companion object {
        val unknown = CoordDomainModel(
            lat = 0.0,
            lon = 0.0
        )
    }
}