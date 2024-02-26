package com.example.weatherapp.presentation.screens.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.base_data.model.ResponseStatus
import com.example.weatherapp.data.mappers.toUIModel
import com.example.weatherapp.data.mappers.toUiModel
import com.example.weatherapp.domain.use_cases.weather_five_and_hours.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.weather_five.GetCurrentWeatherDayAndHoursUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getCurrentWeatherDayAndHoursUseCase: GetCurrentWeatherDayAndHoursUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, _ -> }

    init {
        getCurrentWeatherData()
    }

    fun getCurrentWeatherData() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.tryEmit(MainScreenUiState.Loading)
            val responseForCurrentWeatherDefirred = async {
                getCurrentWeatherDayAndHoursUseCase()
            }
            val responseForCurrentWeather = async {
                getCurrentWeatherUseCase()
            }
            val currentWeatherData = responseForCurrentWeatherDefirred.await()
            val forecastWeather = responseForCurrentWeatherDefirred.await()
            val weatherView = responseForCurrentWeather.await()
            val weather = responseForCurrentWeather.await()
            if (
                currentWeatherData.status == ResponseStatus.SUCCESS &&
                weatherView.status == ResponseStatus.SUCCESS &&
                forecastWeather.status == ResponseStatus.SUCCESS &&
                weather.status == ResponseStatus.SUCCESS
            ) {
                currentWeatherData.data?.let { currentWeather ->
                    forecastWeather.data?.let { forecastWeather ->
                        weatherView.data?.let { weatherView ->
                            weather.data?.let { weather ->
                                _uiState.update {
                                    MainScreenUiState.Success(
                                        weatherDayInHoursModel = currentWeather.toUiModel(),
                                        uiModel = weatherView.toUIModel()
                                    )
                                }
                            }
                        }
                    }
                }
            } else if (
                currentWeatherData.errorThrowable?.message == "CONNECTION_ERROR_MESSAGE" &&
                weatherView.errorThrowable?.message == "CONNECTION_ERROR_MESSAGE"
            ) {
                _uiState.update {
                    MainScreenUiState.Error(
                        currentWeatherData.errorThrowable.message.orEmpty(),
                    )
                }
            }
        }
    }
}