package com.example.arunmarkandu_assignment1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Forecast(
    val temp: ForecastTemp,
    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    val pressure: Float,
    val humidity: Int,
) : Parcelable
