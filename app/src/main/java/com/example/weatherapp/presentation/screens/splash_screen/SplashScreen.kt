package com.example.weatherapp.presentation.screens.splash_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.component.WeatherLottieAnim
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SPLASH_SCREEN_MILLIS = 3000L

@SuppressLint("ResourceType")
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    callbackScreen: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()
    val colorBackground = MaterialTheme.colorScheme.background
    SideEffect {
        systemUiController.setSystemBarsColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }
    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(SPLASH_SCREEN_MILLIS)
            callbackScreen()
        }
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      WeatherLottieAnim(
          modifier = modifier.size(220.dp),
          R.raw.splash_anim
      )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        callbackScreen = {},
    )
}

