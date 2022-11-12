package com.ics342.weatherappcompose.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ics342.weatherappcompose.R
import com.ics342.weatherappcompose.models.*

import com.ics342.weatherappcompose.toHourMinute
import com.ics342.weatherappcompose.toMonthDay
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.List

val startDay = 1665014340L
val sunrise = 1664953200L
val sunset = 1664996400L

val forecastData = (0 until 16).map {
    DayForecast(
        date = startDay,
        sunrise = sunrise + (it * (24 * 60 * 60)),
        sunset = sunrise + (it * 24 * 60 * 60),
        forecastTemp = ForecastTemp(min = 70f + it, max = 80f + it),
        pressure = 1024f,
        humidity = 76,
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun forecastScreen(
    viewModel: ForecastScreenViewModel = hiltViewModel(),
) {

    val state by viewModel.forecastData.collectAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    Scaffold(topBar = { AppBar(title = stringResource(id = R.string.forecast_name)) }) {
        state?.let {
            LazyColumn {
                items(items = it.forecastDataItems) { item: ForecastDataItem ->
                    ForecastRow(item = item)
                }
            }
        }
    }
}

@Composable
private fun ForecastRow(item: ForecastDataItem) {
    Row(
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        val textStyle = TextStyle(
            fontSize = 12.sp,

            )
        //Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        val iconUrl = String.format(
            "https://openweathermap.org/img/wn/%s@2x.png",
            item.weather.get(0).iconName
        )
        AsyncImage(
            model = iconUrl,
            modifier = Modifier.size(72.dp),
            contentDescription = "Sunny"
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Text(
            text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column {
            Text(
                text = stringResource(id = R.string.high, item?.temp?.max!!),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.low, item?.temp?.min!!),
                style = textStyle,
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
                style = textStyle,
            )
        }
    }
}

@Preview(
    showSystemUi = true,
)

@Composable
private fun ForecastRowPreview() {
    //ForecastItems<ForecastDataItem> -> ()
}

