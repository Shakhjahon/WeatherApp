package com.example.weatherapp.di

import com.example.weatherapp.data.remote.WeatherService
import com.example.weatherapp.data.repository.GetWeatherRepositoryImpl
import com.example.weatherapp.data.utils.Constants.BASE_URL
import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideGetCurrentWeatherRepository(
        service: WeatherService
    ): GetCurrentWeatherRepository = GetWeatherRepositoryImpl(
        service = service
    )

    @Provides
    @Singleton
    fun provideWeatherService(
        retrofit: Retrofit
    ): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }}


