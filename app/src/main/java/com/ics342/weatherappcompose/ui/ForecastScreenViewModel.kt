package com.ics342.weatherappcompose.ui

import com.service.OpenWeatherMapAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import com.ics342.weatherappcompose.models.ForecastData
import com.ics342.weatherappcompose.models.LatitudeLongitude
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ForecastScreenViewModel @Inject constructor(private val api: OpenWeatherMapAPI): ViewModel() {
    private val _forecastData = Channel<ForecastData>()

    public val forecastData: Flow<ForecastData> = _forecastData.receiveAsFlow()

    fun fetchData() = runBlocking{
        val forecastData = api.getForecast(55347)
        _forecastData.trySend(forecastData)
    }

    fun fetchForecast(latitudeLongitude: LatitudeLongitude?) = runBlocking{
        val forecastData = latitudeLongitude?.let {
            api.getForecast(
                latitudeLongitude.latitude,
                latitudeLongitude.longitude,
            )
        }
        if (forecastData != null) {
            _forecastData.trySend(forecastData)
        }
    }
}