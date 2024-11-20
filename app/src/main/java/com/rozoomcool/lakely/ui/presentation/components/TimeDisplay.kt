package com.rozoomcool.lakely.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TimeDisplay(
    modifier: Modifier = Modifier,
    timeFormat: String = "HH:mm",
    dateFormat: String = "EEE, dd MMM yyyy"
) {
    var currentTime by remember {
        mutableStateOf(getFormattedTime(timeFormat))
    }
    var currentDate by remember {
        mutableStateOf(getFormattedTime(dateFormat))
    }

    LaunchedEffect(timeFormat, dateFormat) {
        while (true) {
            currentTime = getFormattedTime(timeFormat)
            currentDate = getFormattedTime(dateFormat)
            delay(1000)
        }
    }
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = currentTime,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 78.sp,
                )
            )
            Text(
                text = currentDate,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                )
            )
        }
    }
}

fun getFormattedTime(format: String): String {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    return dateFormat.format(Date(System.currentTimeMillis()))
}