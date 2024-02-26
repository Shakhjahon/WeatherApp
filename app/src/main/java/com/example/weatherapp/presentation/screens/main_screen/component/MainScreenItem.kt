package com.example.weatherapp.presentation.screens.main_screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.models.weather_day_in_hours.ListWeatherUiModel
import com.example.weatherapp.presentation.theme.BackRoundCardDefaultItem
import com.example.weatherapp.presentation.theme.dp15
import com.example.weatherapp.presentation.theme.dp20


@Composable
fun MainScreenItem(
    modifier: Modifier = Modifier,
    loadedUiState: ListWeatherUiModel
) {
    val temp = loadedUiState.main.temp.minus(273)
    val weatherData = loadedUiState.dtTxt
    val time = weatherData.split(" ")[1].split(":").take(2).joinToString(":")

    Card(
        modifier = modifier
            .width(57.dp)
            .height(86.dp),
        colors = CardDefaults.cardColors(BackRoundCardDefaultItem),
        shape = RoundedCornerShape(dp15)
    ) {
        Column {
            Text(
                modifier = modifier
                    .padding(horizontal = 14.dp)
                    .padding(top = 8.dp),
                text = time,
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
            )
            Icon(
                modifier = modifier.padding(top = 12.dp, start = 20.dp),
                painter = painterResource(id = R.drawable.weather),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                modifier = modifier.padding(start = 18.dp),
                text = "${temp.toInt()}°С",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Color.White,
            )
        }
    }
}
