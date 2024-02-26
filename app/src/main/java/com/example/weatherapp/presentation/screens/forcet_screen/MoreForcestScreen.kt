package com.example.weatherapp.presentation.screens.forcet_screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.weatherapp.R
import com.example.weatherapp.data.mappers.toUiModel
import com.example.weatherapp.presentation.component.SetSystemBarsColor
import com.example.weatherapp.presentation.component.WeatherTopAppBar
import com.example.weatherapp.presentation.component.common.LoadingScreen
import com.example.weatherapp.presentation.component.common.NoConnectionScreen
import com.example.weatherapp.presentation.theme.BackgroundLight
import com.example.weatherapp.presentation.theme.dp12
import com.example.weatherapp.presentation.theme.dp16
import com.example.weatherapp.presentation.theme.dp6
import kotlinx.coroutines.flow.StateFlow


@Composable
fun MoreForecastScreen(
    modifier: Modifier = Modifier,
    uiStateFlow: StateFlow<MoreForcestIUiState>,
    viewModel: MoreForcestViewModel,
    navControllerPopBackStack: () -> Unit
) {
    when (val mainUiStateFlow = uiStateFlow.collectAsState().value) {
        is MoreForcestIUiState.Loading -> LoadingScreen()
        is MoreForcestIUiState.Loaded -> LoadedMoreForecastScreen(
            model = mainUiStateFlow,
            navControllerPopBackStack = navControllerPopBackStack
        )

        is MoreForcestIUiState.Error -> NoConnectionScreen(
            tryAgainCallback = viewModel::fethcWeatherForecast,
        )
    }
    SetSystemBarsColor(
        setSystemBarsColor = BackgroundLight, setNavigationBarColor = BackgroundLight
    )
}


@Composable
fun LoadedMoreForecastScreen(
    modifier: Modifier = Modifier,
    model: MoreForcestIUiState.Loaded,
    navControllerPopBackStack: () -> Unit
) {
    Scaffold(
        topBar = {
            WeatherTopAppBar(
                title = stringResource(id = R.string.weather),
                icon = true,
                navControllerPopBackStack = navControllerPopBackStack
            )
        }, containerColor = BackgroundLight
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            LazyColumn(
                modifier = modifier
                    .padding(top = dp16)
                    .padding(horizontal = dp6),
                verticalArrangement = Arrangement.spacedBy(dp12)
            ) {
                items(
                    items = model.weatherForFifteenDaysRemote.list
                ) { forecast ->
                    ForecastItem(
                        model = forecast.toUiModel()
                    )
                }
            }
        }
    }
}