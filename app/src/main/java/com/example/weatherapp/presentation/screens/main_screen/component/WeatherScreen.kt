package com.example.weatherapp.presentation.screens.main_screen.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.component.WeatherLottieAnim
import com.example.weatherapp.presentation.screens.main_screen.MainScreenUiState
import com.example.weatherapp.presentation.theme.BackRoundCardDefaultCardItem
import com.example.weatherapp.presentation.theme.BackRoundCardDefaultItem
import com.example.weatherapp.presentation.theme.DividerColors
import com.example.weatherapp.presentation.theme.dp10
import com.example.weatherapp.presentation.theme.dp12
import com.example.weatherapp.presentation.theme.dp13
import com.example.weatherapp.presentation.theme.dp15
import com.example.weatherapp.presentation.theme.dp17
import com.example.weatherapp.presentation.theme.dp20
import com.example.weatherapp.presentation.theme.dp24
import com.example.weatherapp.presentation.theme.dp25
import com.example.weatherapp.presentation.theme.dp45
import com.example.weatherapp.presentation.theme.dp48
import com.example.weatherapp.presentation.theme.dp50
import com.example.weatherapp.presentation.theme.dp8
import com.example.weatherapp.presentation.theme.sp18
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun LoadedMainScreen(
    modifier: Modifier = Modifier,
    loadedUiState: MainScreenUiState.Success,
    onNavigatyToMoreForecast: () -> Unit,
) {
    val weatherSpeed = loadedUiState.uiModel.weatherWindInfo.weatherSpeed
    val weatherHumidity = loadedUiState.uiModel.weatherMain.weatherHumidity
    val weatherPressure = loadedUiState.uiModel.weatherMain.weatherPressure
    val countryName = loadedUiState.uiModel.country.countryModel
    val countryKG = loadedUiState.uiModel.name
    val temperature = (loadedUiState.uiModel.weatherMain.weatherTemperature - 273)
    val weather = loadedUiState.uiModel.weather.firstOrNull()?.weatherDescription
    val sdf = SimpleDateFormat("hh:mm")
    val currentDate = sdf.format(Date())
    val currentDayName = LocalDate.now().dayOfWeek.name

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(dp12),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$countryName,$countryKG",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
            Text(modifier = modifier.padding(top = dp8), text = "$currentDate — ${
                currentDayName.lowercase().replaceFirstChar { it.uppercase() }
            }", fontWeight = FontWeight.Normal, fontSize = 20.sp, color = Color.White)
            WeatherStateLottie(
                loadedUiState = loadedUiState,
                modifier = modifier
                    .fillMaxWidth()
                    .size(180.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "${temperature.toInt()}°С",
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                color = Color.White
            )

            Text(
                modifier = modifier.padding(top = dp8),
                text = "$weather",
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                color = Color.White
            )
            WeatherInfoBlock(
                windSpeed = weatherSpeed, humidity = weatherHumidity, pressure = weatherPressure
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp10)
                    .padding(top = dp24),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "Day",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
                Text(
                    modifier = modifier.padding(start = dp8),
                    text = "Hours",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Divider(
                modifier = modifier.padding(top = dp20), color = DividerColors
            )
            WeatherForecastBlock(
                uiState = loadedUiState, onNavigatyToMoreForecast = onNavigatyToMoreForecast
            )
        }
    }
}

@Composable
fun WeatherForecastBlock(
    uiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
    onNavigatyToMoreForecast: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(top = dp10),
        colors = CardDefaults.cardColors(BackRoundCardDefaultCardItem),
        shape = RoundedCornerShape(dp20)
    ) {
        Column {
            LazyRow(
                modifier = modifier,
                horizontalArrangement = Arrangement.spacedBy(dp15),
                contentPadding = PaddingValues(dp12)
            ) {
                items(
                    items = uiState.weatherDayInHoursModel.list,
                ) { forecast ->
                    MainScreenItem(
                        loadedUiState = forecast
                    )
                }
            }
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp13)
                    .padding(top = dp20)
                    .height(dp50),
                shape = RoundedCornerShape(dp17),
                onClick = { onNavigatyToMoreForecast() },
                colors = ButtonDefaults.buttonColors(BackRoundCardDefaultItem)
            ) {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = "На этой неделе",
                    fontSize = sp18,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun WeatherStateLottie(
    loadedUiState: MainScreenUiState.Success, modifier: Modifier = Modifier
) {
    loadedUiState.uiModel.weather.firstOrNull()?.apply {
        if (isRain) WeatherLottieAnim(rawFile = R.raw.rain_anim, modifier = modifier)
        else if (isSunny) WeatherLottieAnim(rawFile = R.raw.sunnu_anim, modifier = modifier)
        else if (isClouds) WeatherLottieAnim(rawFile = R.raw.clouds_anim, modifier = modifier)
        else if (isSmoke) WeatherLottieAnim(rawFile = R.raw.mist_anim, modifier = modifier)
    }
}

@Preview
@Composable
fun LoadedMainScreenPreview() {
}