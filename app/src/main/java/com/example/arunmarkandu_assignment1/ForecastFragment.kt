package com.example.arunmarkandu_assignment1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.arunmarkandu_assignment1.databinding.FragmentForecastBinding

var list = listOf<Forecast>(
    Forecast(ForecastTemp(3.0F, 65F, 80F), 1664614828000L , 1664614828000L, 1664650828000L, 100F, 1023),
    Forecast(ForecastTemp(4.0F, 66.1F, 81.1F), 1664673900000L , 1664701288000L, 1664737288000L, 101F, 1024),

    Forecast(ForecastTemp(5.0F, 67F, 82F), 1664787748000L , 1664787748000L, 1664737348000L, 103F, 1025),

    Forecast(ForecastTemp(6.0F, 68F, 83F), 1664874208000L , 1664874208000L, 1664737408000L, 104F, 1026),

    Forecast(ForecastTemp(7.0F, 69F, 84F), 1664960668000L , 1664960668000L, 1664737468000L, 105F, 1027),

    Forecast(ForecastTemp(8.0F, 70F, 85F), 1665047128000L , 1665047128000L, 1664737528000L, 106F, 1028),

    Forecast(ForecastTemp(9.0F, 71F, 86F), 1665133588000L , 1665133588000L, 1664737588000L, 107F, 1029),

    Forecast(ForecastTemp(10.0F, 72F, 87F), 1665220048000L , 1665220048000L, 1664737648000L, 108F, 1030),

    Forecast(ForecastTemp(11.0F, 73F, 88F), 1665306508000L , 1665306508000L, 1664737708000L, 109F, 1031),

    Forecast(ForecastTemp(12.0F, 74F, 89F), 1665392968000L , 1665392968000L, 1664737768000L, 110F, 1032),

    Forecast(ForecastTemp(13.0F, 75F, 90F), 1665479428000L , 1665479428000L, 1664737828000L, 111F, 1033),

    Forecast(ForecastTemp(14.0F, 76F, 91F), 1665565888000L , 1665565888000L, 1664737888000L, 112F, 1034),

    Forecast(ForecastTemp(15.0F, 77F, 92F), 1665652348000L , 1665652348000L, 1664737948000L, 113F, 1035),

    Forecast(ForecastTemp(16.0F, 78F, 93F), 1665738808000L , 1665738808000L, 1664738008000L, 114F, 1036),

    Forecast(ForecastTemp(17.0F, 79F, 94F), 1665825268000L , 1665825268000L, 1664738068000L, 115F, 1037),

    Forecast(ForecastTemp(18.0F, 80F, 95F), 1665911728000L , 1665911728000L, 1664738128000L, 116F, 1038)


)
class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()
    /*
    private val data: List<Forecast> = (0..10).map {
        val forecastTemp = ForecastTemp(3.0F, 56.0F, 77.7F)

        Forecast(forecastTemp, it.toLong(), it.toLong(), it.toLong(), it.toFloat(), it.toInt())
    }
    */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(list)
        //binding.forecastList.layoutManager = LinearLayoutManager(requireContext())
    }
}