package com.example.weatherapp.di

import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository
import com.example.weatherapp.domain.use_cases.weather_five_and_hours.DefaultGetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.weather_five_and_hours.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.weather_five.DefaultGetCurrentWeatherDayAndHoursUseCase
import com.example.weatherapp.domain.use_cases.weather_five.GetCurrentWeatherDayAndHoursUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetCurrentWeatherUseCase(
        repository: GetCurrentWeatherRepository,
        getCurrentLocationManagers: GetCurrentLocationManager,
    ): GetCurrentWeatherUseCase = DefaultGetCurrentWeatherUseCase(
        repository = repository,
        getCurrentLocationManagers = getCurrentLocationManagers
    )

    @Provides
    fun provideGetCurrentWeatherDayAndHoursUseCase(
        repository: GetCurrentWeatherRepository,
        getCurrentLocationManager: GetCurrentLocationManager
    ): GetCurrentWeatherDayAndHoursUseCase = DefaultGetCurrentWeatherDayAndHoursUseCase(
        repository = repository,
        getCurrentLocationManagers = getCurrentLocationManager
    )
}
