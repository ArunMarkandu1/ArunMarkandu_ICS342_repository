package com.example.arunmarkandu_assignment1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.arunmarkandu_assignment1.databinding.FragmentCurrentConditionsBinding

class CurrentConditionsFragment : Fragment(R.layout.fragment_current_conditions) {

    private lateinit var binding: FragmentCurrentConditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrentConditionsBinding.bind(view)
        binding.forecastButton.setOnClickListener{
            val forecastTemp = ForecastTemp(3.0F, 58.0F, 72.0F)
            val forecast = Forecast(forecastTemp, 10L, 20L, 30L, 23.4F, 70)
            val action = CurrentConditionsFragmentDirections.actionCurrentConditionsFragmentToForecastFragment2(forecast)
            findNavController().navigate(action)
        }
    }

}