package com.example.weatherapp.presentation.component


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.theme.BackgroundLight
import com.example.weatherapp.presentation.theme.dp10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    icon: Boolean = false,
    navControllerPopBackStack: () -> Unit
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundLight
        ),
        title = {
            Text(
                text = title, fontSize = 24.sp, fontWeight = FontWeight.Medium, color = Color.White
            )
        },
        navigationIcon = {
            if (icon) IconButton(
                modifier = modifier.padding(start = dp10),
                onClick = { navControllerPopBackStack() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null, tint = Color.White,
                )
            }
        },
    )
}

@Preview
@Composable
fun WeatherTopAppBarPreview() {
    WeatherTopAppBar(
        title = "", icon = true,
        navControllerPopBackStack = {}
    )
}