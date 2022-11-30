package com.ics342.weatherappcompose.ui

import com.service.OpenWeatherMapAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import com.ics342.weatherappcompose.models.CurrentConditions
import com.ics342.weatherappcompose.models.LatitudeLongitude
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val api: OpenWeatherMapAPI): ViewModel() {
    private val _currentConditions = Channel<CurrentConditions>()

    public val currentConditions: Flow<CurrentConditions> = _currentConditions.receiveAsFlow()

    fun fetchData() = runBlocking{
        val currentConditions = api.getCurrentConditions("55423")
        _currentConditions.trySend(currentConditions)

    }

    fun fetchCurrentLocationData(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val currentConditions = api.getCurrentConditions(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _currentConditions.trySend(currentConditions)
    }


}