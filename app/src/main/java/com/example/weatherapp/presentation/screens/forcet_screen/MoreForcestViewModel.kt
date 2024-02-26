package com.example.weatherapp.presentation.screens.forcet_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.base_data.model.ResponseStatus
import com.example.weatherapp.domain.use_cases.weather_five.GetCurrentWeatherDayAndHoursUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreForcestViewModel @Inject constructor(
    private val getCurrentWeatherDayAndHoursUseCase: GetCurrentWeatherDayAndHoursUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MoreForcestIUiState>(MoreForcestIUiState.Loading)
    val uiState: StateFlow<MoreForcestIUiState> = _uiState.asStateFlow()

    init {
        fethcWeatherForecast()
    }

     fun fethcWeatherForecast() {
        viewModelScope.launch {
            val response = getCurrentWeatherDayAndHoursUseCase()
            when (response.status) {
                ResponseStatus.SUCCESS -> {
                    response.data?.let { forecastList ->
                        _uiState.update {
                            MoreForcestIUiState.Loaded(
                                weatherForFifteenDaysRemote = forecastList
                            )
                        }
                    }
                }
                ResponseStatus.ERROR -> {

                }
            }
        }
    }
}