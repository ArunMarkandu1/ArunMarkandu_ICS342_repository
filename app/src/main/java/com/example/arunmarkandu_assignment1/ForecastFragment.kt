package com.example.arunmarkandu_assignment1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.arunmarkandu_assignment1.databinding.FragmentForecastBinding

var list = listOf<Forecast>(
    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664614828000L , 1664614828000L, 1664647228L, 100F, 1023),
    Forecast(ForecastTemp(4.0F, 56.1F, 77.1F), 14L , 600L, 800L, 200F, 1012),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023),

    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664629228000L , 1664629228000L, 1664647228L, 100F, 1023)


)
class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()
    private val data: List<Forecast> = (0..10).map {
        val forecastTemp = ForecastTemp(3.0F, 56.0F, 77.7F)

        Forecast(forecastTemp, it.toLong(), it.toLong(), it.toLong(), it.toFloat(), it.toInt())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(list)
        //binding.forecastList.layoutManager = LinearLayoutManager(requireContext())
    }
}