package com.example.weatherapp.data.models.weather_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountryModel(

    @SerializedName("country")
    val countryModel: String,
    ) : Serializable {
        companion object {
            val unknown = CountryModel(
                countryModel = ""
            )
        }
    }