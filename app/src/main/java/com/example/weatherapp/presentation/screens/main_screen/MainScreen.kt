package com.example.weatherapp.presentation.screens.main_screen

import android.annotation.SuppressLint
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.presentation.component.SetSystemBarsColor
import com.example.weatherapp.presentation.component.WeatherTopAppBar
import com.example.weatherapp.presentation.component.common.LoadingScreen
import com.example.weatherapp.presentation.component.common.NoConnectionScreen
import com.example.weatherapp.presentation.models.weather.WeatherUIModel
import com.example.weatherapp.presentation.models.weather_day_in_hours.WeatherDayInHoursUiModel
import com.example.weatherapp.presentation.screens.main_screen.component.LoadedMainScreen
import com.example.weatherapp.presentation.theme.BackgroundLight
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    uiStateFlow: StateFlow<MainScreenUiState>,
    callBackPopBackSplash: () -> Unit,
    onNavigatyToMoreForecast: () -> Unit,
) {
    val backstackDispatcher = LocalOnBackPressedDispatcherOwner.current

    backstackDispatcher?.onBackPressedDispatcher?.addCallback {
        callBackPopBackSplash()
    }
    SetSystemBarsColor(
        setSystemBarsColor = if (isSystemInDarkTheme()) BackgroundLight else BackgroundLight,
        setNavigationBarColor = if (isSystemInDarkTheme()) BackgroundLight else BackgroundLight,
    )
    when (val mainUiStateFlow = uiStateFlow.collectAsState().value) {
        is MainScreenUiState.Loading -> LoadingScreen()
        is MainScreenUiState.Success -> MainScreens(
            uiState = mainUiStateFlow, onNavigatyToMoreForecast = onNavigatyToMoreForecast
        )

        is MainScreenUiState.Error -> NoConnectionScreen(
            tryAgainCallback = viewModel::getCurrentWeatherData,
        )
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreens(
    uiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
    onNavigatyToMoreForecast: () -> Unit
) {
    Scaffold(
        topBar = { WeatherTopAppBar(title = "Weather" , icon = false, navControllerPopBackStack = {}) }, containerColor = BackgroundLight
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            LoadedMainScreen(
                loadedUiState = uiState, onNavigatyToMoreForecast = onNavigatyToMoreForecast
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreens(uiState = MainScreenUiState.Success(
        uiModel = WeatherUIModel.unknown,
        weatherDayInHoursModel = WeatherDayInHoursUiModel.unknown,
    ), onNavigatyToMoreForecast = {})
}