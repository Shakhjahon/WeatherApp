package com.example.weatherapp.domain.use_cases.weather_five

import com.example.weatherapp.data.base_data.model.ResultStatus
import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.models.weather_five_in_hours.WeatherDayInHoursDomainModel
import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository
import javax.inject.Inject

class DefaultGetCurrentWeatherDayAndHoursUseCase @Inject constructor(
    private val repository: GetCurrentWeatherRepository,
    private val getCurrentLocationManagers: GetCurrentLocationManager,
) : GetCurrentWeatherDayAndHoursUseCase {
    override suspend fun invoke(): ResultStatus<WeatherDayInHoursDomainModel> {
        val currentLocation = getCurrentLocationManagers.getCurrentLocation()

        return if (currentLocation != null) repository.getCurrentWeatherDayInHours(
            latitude = currentLocation.latitude,
            longitude = currentLocation.longitude,
        ) else return repository.getCurrentWeatherDayInHours(0.0,0.0)
    }
}
