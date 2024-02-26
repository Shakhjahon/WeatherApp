package com.example.weatherapp.domain.use_cases.weather_five_and_hours

import com.example.weatherapp.data.base_data.model.ResultStatus
import com.example.weatherapp.domain.models.weather_domain.WeatherDomainModel

interface GetCurrentWeatherUseCase {

    suspend operator fun invoke(): ResultStatus<WeatherDomainModel>

}