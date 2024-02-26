package com.example.weatherapp.presentation.navGraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.presentation.screens.forcet_screen.MoreForcestIUiState
import com.example.weatherapp.presentation.screens.forcet_screen.MoreForcestViewModel
import com.example.weatherapp.presentation.screens.forcet_screen.MoreForecastScreen
import com.example.weatherapp.presentation.screens.main_screen.MainScreen
import com.example.weatherapp.presentation.screens.main_screen.MainScreenViewModel
import com.example.weatherapp.presentation.screens.splash_screen.SplashScreen


@Composable
fun AppNavGraph(
    callBackPopBackSplash: () -> Unit,
) {

    val navController = rememberNavController()
    val mainScreenRoute = Screens.MainScreen.route.toString()
    val splashScreenRoute = Screens.SplashScreen.route.toString()
    val moreForecast = Screens.MoreForecastScreen.route.toString()


    NavHost(
        navController = navController,
        startDestination = splashScreenRoute,
    ) {

        composable(splashScreenRoute) {
            SplashScreen(
                callbackScreen = {
                    navController.navigate(mainScreenRoute)
                }
            )
        }

        composable(mainScreenRoute) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            MainScreen(
                uiStateFlow = viewModel.uiState,
                viewModel = viewModel,
                callBackPopBackSplash = callBackPopBackSplash,
                onNavigatyToMoreForecast = {
                    navController.navigate(moreForecast)
                }
            )
        }
        composable(moreForecast) {
            val viewModel: MoreForcestViewModel = hiltViewModel()
            MoreForecastScreen(
                uiStateFlow = viewModel.uiState,
                viewModel = viewModel,
                navControllerPopBackStack = {navController.popBackStack()}
            )
        }
    }
}