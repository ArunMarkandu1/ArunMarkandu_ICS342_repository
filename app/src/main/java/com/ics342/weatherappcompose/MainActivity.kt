package com.ics342.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ics342.weatherappcompose.models.ForecastData
import com.ics342.weatherappcompose.ui.CurrentConditions
import com.ics342.weatherappcompose.ui.ForecastScreenViewModel
import com.ics342.weatherappcompose.ui.forecastData
import com.ics342.weatherappcompose.ui.forecastScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "CurrentConditions"){
                composable("CurrentConditions"){
                    CurrentConditions{
                        navController.navigate("Forecast")
                    }
                }

                composable("Forecast"){
                    forecastScreen()
                }
            }
        }
    }
}


