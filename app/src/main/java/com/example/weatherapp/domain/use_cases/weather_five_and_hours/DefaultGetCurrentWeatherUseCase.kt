package com.example.weatherapp.domain.use_cases.weather_five_and_hours

import com.example.weatherapp.data.base_data.model.ResultStatus
import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.models.weather_domain.WeatherDomainModel
import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository
import javax.inject.Inject

class DefaultGetCurrentWeatherUseCase @Inject constructor(
    private val repository: GetCurrentWeatherRepository,
    private val getCurrentLocationManagers: GetCurrentLocationManager,
) : GetCurrentWeatherUseCase {
    override suspend fun invoke(): ResultStatus<WeatherDomainModel> {
        val currentLocation = getCurrentLocationManagers.getCurrentLocation()

        return if (currentLocation != null) repository.getCurrentWeatherData(
            latitude = currentLocation.latitude,
            longitude = currentLocation.longitude,
        ) else return repository.getCurrentWeatherData(40.513996, 72.816101)
    }
}