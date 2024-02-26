package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.models.weather_model.CountryModel
import com.example.weatherapp.data.models.weather_model.WeatherCloudModel
import com.example.weatherapp.data.models.weather_model.WeatherCloudsModel
import com.example.weatherapp.data.models.weather_model.WeatherCoordinateModel
import com.example.weatherapp.data.models.weather_model.WeatherDataModel
import com.example.weatherapp.data.models.weather_model.WeatherMainModel
import com.example.weatherapp.data.models.weather_model.WeatherWindInfoModel
import com.example.weatherapp.domain.models.weather_domain.CountryModelDomain
import com.example.weatherapp.domain.models.weather_domain.WeatherCloudModelDomain
import com.example.weatherapp.domain.models.weather_domain.WeatherCloudsModelDomain
import com.example.weatherapp.domain.models.weather_domain.WeatherCoordinateModelDomain
import com.example.weatherapp.domain.models.weather_domain.WeatherDomainModel
import com.example.weatherapp.domain.models.weather_domain.WeatherMainModelDomain
import com.example.weatherapp.domain.models.weather_domain.WeatherWindInfoModelDomain
import com.example.weatherapp.presentation.models.weather.CountryModelUi
import com.example.weatherapp.presentation.models.weather.WeatherCloudModelUi
import com.example.weatherapp.presentation.models.weather.WeatherCloudsModelUi
import com.example.weatherapp.presentation.models.weather.WeatherCoordinateModelUi
import com.example.weatherapp.presentation.models.weather.WeatherMainModelUI
import com.example.weatherapp.presentation.models.weather.WeatherUIModel
import com.example.weatherapp.presentation.models.weather.WeatherWindInfoModelUI

fun WeatherDataModel.toDomainModel() = WeatherDomainModel(
    coord = weatherCoordinate.toDomainModel(),
    weather = weather.map { it.toDomainModel() },
    weatherBase = weatherBase,
    weatherMain = weatherMain.toDomainModel(),
    visibility = visibility,
    weatherWindInfo = weatherWindowInfo.toDomainModel(),
    weatherClouds = weatherClouds.toDomainModel(),
    name = name,
    country = country.toDomainModel()
)

fun WeatherCloudModel.toDomainModel() = WeatherCloudModelDomain(
    weatherMain = weatherMain,
    weatherId = weatherId,
    weatherDescription = weatherDescription
)

fun WeatherCloudsModel.toDomainModel() = WeatherCloudsModelDomain(
    all = all
)

fun WeatherCoordinateModel.toDomainModel() = WeatherCoordinateModelDomain(
    longitude = latitude,
    latitude = latitude
)

fun WeatherMainModel.toDomainModel() = WeatherMainModelDomain(
    weatherTemperature = weatherTemperature,
    feelsLike = feelsLike,
    weatherMinTemp = weatherMinTemp,
    weatherMaxTemp = weatherMaxTemp,
    weatherPressure = weatherPressure,
    weatherHumidity = weatherHumidity
)

fun WeatherWindInfoModel.toDomainModel() = WeatherWindInfoModelDomain(
    weatherSpeed = weatherSpeed,
    weatherDag = weatherDag
)

fun CountryModel.toDomainModel() = CountryModelDomain(
    countryModel = countryModel
)
////////////////////////  UI MAPPERS  ///////////////////////////////////

fun WeatherDomainModel.toUIModel() = WeatherUIModel(
    coord = coord.toUIModel(),
    weather = weather.map { it.toUIModel() },
    weatherBase = weatherBase,
    weatherMain = weatherMain.toUIModel(),
    visibility = visibility,
    weatherWindInfo = weatherWindInfo.toUIModel(),
    weatherClouds = weatherClouds.toUIModel(),
    name = name,
    country = country.toUIModel()
)

fun WeatherCloudModelDomain.toUIModel() = WeatherCloudModelUi(
    weatherMain = weatherMain,
    weatherId = weatherId,
    weatherDescription = weatherDescription
)

fun WeatherCloudsModelDomain.toUIModel() = WeatherCloudsModelUi(
    all = all
)

fun WeatherCoordinateModelDomain.toUIModel() = WeatherCoordinateModelUi(
    longitude = latitude,
    latitude = latitude
)

fun WeatherMainModelDomain.toUIModel() = WeatherMainModelUI(
    weatherTemperature = weatherTemperature,
    feelsLike = feelsLike,
    weatherMinTemp = weatherMinTemp,
    weatherMaxTemp = weatherMaxTemp,
    weatherPressure = weatherPressure,
    weatherHumidity = weatherHumidity
)

fun WeatherWindInfoModelDomain.toUIModel() = WeatherWindInfoModelUI(
    weatherSpeed = weatherSpeed,
    weatherDag = weatherDag
)

fun CountryModelDomain.toUIModel() = CountryModelUi(
    countryModel = countryModel
)