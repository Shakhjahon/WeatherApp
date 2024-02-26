package com.example.weatherapp.presentation.navGraph

import androidx.annotation.StringRes
import com.example.weatherapp.R

sealed class Screens(@StringRes val route: Int) {
    data object SplashScreen : Screens(R.string.splashScreen)
    data object MainScreen : Screens(R.string.mainScreen)
    data object MoreForecastScreen : Screens(R.string.moreForecast)

}