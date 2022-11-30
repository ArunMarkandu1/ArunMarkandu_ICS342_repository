package com.ics342.weatherappcompose.models

import com.squareup.moshi.Json

data class ForecastWeatherData(
    @Json(name = "icon")
    val iconName: String = "04d",
)

data class Temp(
    @Json(name = "min")
    val min: Float = 0F,

    @Json(name = "max")
    val max: Float = 0F,

    @Json(name = "day")
    val day: Float = 0F,
)

data class ForecastDataItem(
    @Json(name = "dt")
    val date: Long = 0L,

    @Json(name = "sunrise")
    val sunrise: Long = 0L,

    @Json(name = "sunset")
    val sunset: Long = 0L,

    @Json(name = "temp")
    val temp: Temp? = Temp(),

    @Json(name = "weather")
    val weather: List<ForecastWeatherData> = ArrayList(),
)

data class ForecastData(
    @Json(name = "list")
    val forecastDataItems: List<ForecastDataItem>,

    @Json(name = "temp")
    val temper: Temp = Temp(),

    @Json(name = "weather")
    val weather: List<ForecastWeatherData> = ArrayList(),
)