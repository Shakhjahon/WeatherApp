package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.models.weather_five_in_hours.CityDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.CloudsDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.CoordDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.ListWeatherData
import com.example.weatherapp.data.models.weather_five_in_hours.MainDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.SnowDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.SysDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.WeatherDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.WeatherDayInHoursDataModel
import com.example.weatherapp.data.models.weather_five_in_hours.WindDataModel
import com.example.weatherapp.domain.models.weather_five_in_hours.CityDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.CloudsDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.CoordDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.ListWeatherDomain
import com.example.weatherapp.domain.models.weather_five_in_hours.MainDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.SnowDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.SysDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.WeatherDayInHoursDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.WeatherDomainModel
import com.example.weatherapp.domain.models.weather_five_in_hours.WindDomainModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.CityUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.CloudsUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.CoordUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.ListWeatherUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.MainUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.SnowUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.SysUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.WeatherDayInHoursUiModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.WeatherUiModelDay
import com.example.weatherapp.presentation.models.weather_day_in_hours.WindUiModel


fun WeatherDayInHoursDataModel.toDomainModel() = WeatherDayInHoursDomainModel(
    city = city.toDataModel(),
    cnt = cnt,
    cod = cod,
    list = list.map { it.toDomainModel() },
    message = message,
)

fun ListWeatherData.toDomainModel() = ListWeatherDomain(
    clouds = clouds.toDataModel(),
    dt = dt,
    dtTxt = dtTxt,
    main = main.toDataModel(),
    pop = pop,
    snow = snow?.toDataModel(),
    sys = sys.toDataModel(),
    visibility = visibility,
    weather = weather.map { it.toDataModel() },
    wind = wind.toDataModel(),
)

fun CityDataModel.toDataModel() = CityDomainModel(
    coord = coord.toDataModel(),
    country = country,
    id = id,
    name = name,
    population = population,
    sunrise = sunrise,
    sunset = sunset,
    timezone = timezone,
)

fun CoordDataModel.toDataModel() = CoordDomainModel(
    lat = lat,
    lon = lon
)

fun CloudsDataModel.toDataModel() = CloudsDomainModel(
    all = all
)

fun MainDataModel.toDataModel() = MainDomainModel(
    feelsLike = feelsLike,
    grndLevel = grndLevel,
    humidity = humidity,
    pressure = pressure,
    seaLevel = seaLevel,
    temp = temp,
    tempKf = tempKf,
    tempMax = tempMax,
    tempMin = tempMin
)

fun SnowDataModel.toDataModel() = SnowDomainModel(
    h = h
)

fun SysDataModel.toDataModel() = SysDomainModel(
    pod = pod
)

fun WeatherDataModel.toDataModel() = WeatherDomainModel(
    description = description,
    icon = icon,
    id = id,
    main = main
)

fun WindDataModel.toDataModel() = WindDomainModel(
    deg = deg,
    gust = gust,
    speed = speed
)


fun WeatherDayInHoursDomainModel.toUiModel() = WeatherDayInHoursUiModel(
    city = city.toUiModel(),
    cnt = cnt,
    cod = cod,
    list = list.map { it.toUiModel() },
    message = message,
)

fun ListWeatherDomain.toUiModel() = ListWeatherUiModel(
    clouds = clouds.toUiModel(),
    dt = dt,
    dtTxt = dtTxt,
    main = main.toUiModel(),
    pop = pop,
    snow = snow?.toUiModel(),
    sys = sys.toUiModel(),
    visibility = visibility,
    weather = weather.map { it.toUiModel() },
    wind = wind.toUiModel(),
)

fun CityDomainModel.toUiModel() = CityUiModel(
    coord = coord.toUiModel(),
    country = country,
    id = id,
    name = name,
    population = population,
    sunrise = sunrise,
    sunset = sunset,
    timezone = timezone,
)

fun CoordDomainModel.toUiModel() = CoordUiModel(
    lat = lat,
    lon = lon
)

fun CloudsDomainModel.toUiModel() = CloudsUiModel(
    all = all
)

fun MainDomainModel.toUiModel() = MainUiModel(
    feelsLike = feelsLike,
    grndLevel = grndLevel,
    humidity = humidity,
    pressure = pressure,
    seaLevel = seaLevel,
    temp = temp,
    tempKf = tempKf,
    tempMax = tempMax,
    tempMin = tempMin
)

fun SnowDomainModel.toUiModel() = SnowUiModel(
    h = h
)

fun SysDomainModel.toUiModel() = SysUiModel(
    pod = pod
)

fun WeatherDomainModel.toUiModel() = WeatherUiModelDay(
    description = description,
    icon = icon,
    id = id,
    main = main
)

fun WindDomainModel.toUiModel() = WindUiModel(
    deg = deg,
    gust = gust,
    speed = speed
)












