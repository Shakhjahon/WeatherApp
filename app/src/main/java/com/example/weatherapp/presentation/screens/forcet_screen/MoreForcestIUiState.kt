package com.example.weatherapp.presentation.screens.forcet_screen

import com.example.weatherapp.domain.models.weather_five_in_hours.WeatherDayInHoursDomainModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MoreForcestIUiState {

    data class Loaded(
        val weatherForFifteenDaysRemote: WeatherDayInHoursDomainModel
    ) : MoreForcestIUiState()

   data object Loading : MoreForcestIUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : MoreForcestIUiState()
}