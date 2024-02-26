package com.example.weatherapp.presentation.models.weather

import java.io.Serializable

data class CountryModelUi(
    val countryModel: String,
) : Serializable {
    companion object {
        val unknown = CountryModelUi(
            countryModel = ""
        )
    }
}