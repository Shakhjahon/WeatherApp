package com.example.weatherapp.presentation.screens.forcet_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.weatherapp.presentation.models.weather_day_in_hours.ListWeatherUiModel
import com.example.weatherapp.presentation.theme.BackRoundCardDefaultItem
import com.example.weatherapp.presentation.theme.dp115
import com.example.weatherapp.presentation.theme.dp15
import com.example.weatherapp.presentation.theme.dp29
import com.example.weatherapp.presentation.theme.dp3
import com.example.weatherapp.presentation.theme.dp5
import com.example.weatherapp.presentation.theme.dp6
import com.example.weatherapp.presentation.theme.dp7
import com.example.weatherapp.presentation.theme.dp9
import com.example.weatherapp.presentation.theme.sp20
import com.example.weatherapp.presentation.theme.sp26
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun ForecastItem(
    modifier: Modifier = Modifier, model: ListWeatherUiModel
) {
    val temp = model.main.temp.minus(273)
    val maxTemp = model.main.tempMax.minus(273)
    val minTemp = model.main.tempMin.minus(273)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dp6)
            .height(dp115),
        shape = RoundedCornerShape(dp15),
        colors = CardDefaults.cardColors(BackRoundCardDefaultItem),
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = dp9)
                .padding(top = dp7)
        ) {
            Row(
                modifier = modifier.fillMaxWidth()
            ) {
                Column(modifier = modifier.weight(1f)) {
                    Text(
                        text = parseWeatherDate(model.dtTxt, ParseDateTypes.DAYOFWEEK),
                        fontSize = sp20,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Text(
                        text = parseWeatherDate(model.dtTxt, ParseDateTypes.TIME),
                        color = Color.White
                    )
                }
                Text(
                    modifier = modifier.padding(dp5),
                    text = "${temp.toInt()}°С",
                    fontSize = sp26,
                    color = Color.White,

                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = dp29)
            ) {
                Text(
                    modifier = modifier.weight(1f),
                    text = parseWeatherDate(
                        model.dtTxt, ParseDateTypes.MONTH
                    ),
                    color = Color.White
                )
                Text(
                    modifier = modifier.padding(end = dp3),
                    text = "макс.:${maxTemp.toInt()}°",
                    color = Color.White
                )
                Text(
                    text = "мин.:${minTemp.toInt()}°",
                    color = Color.White
                )
            }
        }
    }
}


private fun parseWeatherDate(
    dateText: String,
    parseDateTypes: ParseDateTypes,
): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateText, formatter)
    val dayOfWeek = dateTime.dayOfWeek
    val dayNameOfWeek = dayOfWeek.getDisplayName(
        TextStyle.FULL, Locale.getDefault()
    )
    val dayHour = dateTime.hour
    val dateMonth = dateTime.dayOfMonth

    return when (parseDateTypes) {
        ParseDateTypes.DAYOFWEEK -> dayNameOfWeek
        ParseDateTypes.TIME -> "$dayHour:00"
        ParseDateTypes.MONTH -> "$dateMonth ${getMonthName(dateTime.monthValue)}"
    }
}

fun getMonthName(monthValue: Int): String {
    return when (monthValue) {
        1 -> "январь"
        2 -> "Февраль"
        3 -> "март"
        4 -> "апрель"
        5 -> "май"
        6 -> "июнь"
        7 -> "июль"
        8 -> "август"
        9 -> "сентябрь"
        10 -> "октябрь"
        11 -> "ноябрь"
        12 -> "декабрь"
        else -> String()
    }
}

//@Preview
//@Composable
//fun ForecastPreview() {
//    MaterialTheme {
//        ForecastItem()
//    }
//}