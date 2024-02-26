package com.example.weatherapp.presentation.screens.main_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.theme.BoxGradientColorGrayBlue
import com.example.weatherapp.presentation.theme.BoxGradientColorWhiteBlue
import com.example.weatherapp.presentation.theme.dp12
import com.example.weatherapp.presentation.theme.dp16
import com.example.weatherapp.presentation.theme.dp4
import com.example.weatherapp.presentation.theme.dp5
import com.example.weatherapp.presentation.theme.dp66


@Composable
fun WeatherInfoBlock(
    modifier: Modifier = Modifier,
    windSpeed: Int,
    humidity: Int,
    pressure: Int,
) {
    Box(
        modifier = modifier
            .padding(horizontal = dp4)
            .padding(top = dp16)
            .fillMaxWidth()
            .height(dp66)
            .clip(RoundedCornerShape(dp12))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        BoxGradientColorWhiteBlue,
                        BoxGradientColorGrayBlue,
                    )
                )
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Spacer(modifier = modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.noun_rain_2438520_1),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "$humidity %",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = modifier.padding(start = dp5)
            )
            Spacer(modifier = modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.pressure_svgrepo_com),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "$pressure",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = modifier.padding(start = dp5)
            )
            Spacer(modifier = modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.noun_wind_4507827_1),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "$windSpeed km/h",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = modifier.padding(start = dp5)
            )
            Spacer(modifier = modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun WeatherInfoBlockPrew() {
    WeatherInfoBlock(windSpeed = 1, humidity = 1, pressure = 1)
}