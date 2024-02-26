package com.example.weatherapp.di

import android.app.Application
import com.example.weatherapp.domain.managers.DefaultGetCurrentLocationManager
import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class ManagerModule {

    @Provides
    fun provideGetCurrentLocationManager(
        applicationContexts: Application
    ): GetCurrentLocationManager = DefaultGetCurrentLocationManager(
        application = applicationContexts,
        locationProviderClient = LocationServices.getFusedLocationProviderClient(applicationContexts),
    )
}