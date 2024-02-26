package com.example.weatherapp.domain.use_cases.weather_five

import com.example.weatherapp.data.base_data.model.ResultStatus
import com.example.weatherapp.domain.models.weather_five_in_hours.WeatherDayInHoursDomainModel

interface GetCurrentWeatherDayAndHoursUseCase {
    suspend operator fun invoke(): ResultStatus<WeatherDayInHoursDomainModel>
}