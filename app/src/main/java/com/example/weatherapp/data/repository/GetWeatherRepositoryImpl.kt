package com.example.weatherapp.data.repository

import com.example.weatherapp.data.base_data.BaseDataSource
import com.example.weatherapp.data.base_data.model.ResultStatus
import com.example.weatherapp.data.mappers.toDomainModel
import com.example.weatherapp.data.remote.WeatherService
import com.example.weatherapp.domain.models.weather_domain.WeatherDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.WeatherDayInHoursDomainModel
import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository
import com.example.weatherapp.presentation.models.weather_day_in_hours.ListWeatherUiModel
import javax.inject.Inject

class GetWeatherRepositoryImpl @Inject constructor(
    private val service: WeatherService
) : GetCurrentWeatherRepository, BaseDataSource() {

    override suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double
    ): ResultStatus<WeatherDomainModel> {
        val response = invokeResponseRequest {
            service.getCurrentWeather(
                latitude = latitude,
                longitude = longitude
            )
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomainModel()
        )
    }

    override suspend fun getCurrentWeatherDayInHours(
        latitude: Double,
        longitude: Double
    ): ResultStatus<WeatherDayInHoursDomainModel> {
        val response = invokeResponseRequest {
            service.getCurrentWeatherDayInHours(
                latitude = latitude,
                longitude = longitude
            )
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomainModel()
        )
    }
}
