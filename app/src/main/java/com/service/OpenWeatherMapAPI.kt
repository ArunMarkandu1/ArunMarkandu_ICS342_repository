package com.service

import com.ics342.weatherappcompose.models.CurrentConditions
import com.ics342.weatherappcompose.models.ForecastData
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapAPI {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip")zip: String,
        @Query("appid") apiKey: String = "59960ddbd19bfc397e221364992e5673",
        @Query("units") units: String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("zip") zip: Int,
        @Query("appid") apiKey: String = "59960ddbd19bfc397e221364992e5673",
    ) : ForecastData
}