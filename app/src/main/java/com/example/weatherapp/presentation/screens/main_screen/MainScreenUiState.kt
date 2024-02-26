package com.example.weatherapp.presentation.screens.main_screen

import com.example.weatherapp.presentation.models.weather.WeatherUIModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.WeatherDayInHoursUiModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenUiState {

    @Immutable
    data class Success(
        val uiModel: WeatherUIModel = WeatherUIModel.unknown,
        val weatherDayInHoursModel: WeatherDayInHoursUiModel
    ) : MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : MainScreenUiState()
}