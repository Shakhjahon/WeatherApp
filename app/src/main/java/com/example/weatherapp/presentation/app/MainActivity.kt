package com.example.weatherapp.presentation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.presentation.navGraph.AppNavGraph
import com.example.weatherapp.presentation.screens.main_screen.MainScreenViewModel
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import com.example.weatherapp.presentation.permishensUtils.StartRequestPermission
import com.example.weatherapp.presentation.permishensUtils.getActivity
import com.example.weatherapp.presentation.permishensUtils.isPermissionsGranted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: MainScreenViewModel = hiltViewModel()
                    val context = LocalContext.current
                    var startAppNavGraph by remember {
                        mutableStateOf(false)
                    }
                    if (isPermissionsGranted(context)) {
                        AppNavGraph(
                            callBackPopBackSplash = { context.getActivity()?.finish() }
                        )
                    } else {
                        StartRequestPermission(context = LocalContext.current) {
                            startAppNavGraph = true
                        }
                    }
                    if (startAppNavGraph) AppNavGraph(
                        callBackPopBackSplash = { context.getActivity()?.finish() }
                    )
                }
            }
        }
    }
}

