package com.example.weatherapp.presentation.component.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.component.WeatherLottieAnim
import com.example.weatherapp.presentation.theme.TaskerBlue
import com.example.weatherapp.presentation.theme.dp16
import com.example.weatherapp.presentation.theme.dp40
import com.example.weatherapp.presentation.theme.dp8


@Composable
fun NoConnectionScreen(
    tryAgainCallback: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            WeatherLottieAnim(
                rawFile = R.raw.no_internet,
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = stringResource(R.string.looding),
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
            )
            Button(
                onClick = {
                    tryAgainCallback()
                },
                colors = ButtonDefaults.buttonColors(TaskerBlue),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp16)
                    .padding(top = dp8)
            ) {
                Text(
                    text = "Повторить",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun Previews() {
    NoConnectionScreen {
    }
}

@Composable
fun ErrorScreens(
    massage: String,
    tryAgainCallback: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(
                modifier = Modifier.padding(start = dp40),
                text = massage,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
            )
            Button(
                onClick = {
                    tryAgainCallback()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp16)
            ) {
                Text(text = "Повторить")
            }
        }
    }
}