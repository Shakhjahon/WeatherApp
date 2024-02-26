package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.base_data.model.ResultStatus
import com.example.weatherapp.domain.models.weather_domain.WeatherDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.WeatherDayInHoursDomainModel


interface GetCurrentWeatherRepository {

    suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double,
    ): ResultStatus<WeatherDomainModel>

    suspend fun getCurrentWeatherDayInHours(
        latitude: Double,
        longitude: Double,
    ): ResultStatus<WeatherDayInHoursDomainModel>
}