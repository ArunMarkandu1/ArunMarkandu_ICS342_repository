/*
package com.example.arunmarkandu_assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class ForecastAdapter(private val data: List<Forecast>) : RecyclerView.Adapter<ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val forecastDay : TextView
    val forecastHigh : TextView
    val forecastLow : TextView
    val forecastDate : TextView
    val forecastSunset : TextView
    val forecastSunrise : TextView
    val forecastPressure : TextView
    val forecastHumidity : TextView

    init{
        forecastDay = view.findViewById(R.id.forecast_temp)
        forecastHigh = view.findViewById(R.id.forecast_high)
        forecastLow = view.findViewById(R.id.forecast_low)
        forecastDate = view.findViewById(R.id.forecast_date)
        forecastSunset = view.findViewById(R.id.forecast_sunset)
        forecastSunrise = view.findViewById(R.id.forecast_sunrise)
        forecastPressure = view.findViewById(R.id.forecast_pressure)
        forecastHumidity = view.findViewById(R.id.forecast_humidity)
    }

    fun bind(data: Forecast){
        forecastDay.text = "Temp: " + data.temp.day.toString() + "°"
        forecastHigh.text = "High: " + data.temp.max.toString() + "°" + " Low: " + data.temp.min.toString() + "°"
        //forecastLow.text = "Low " + data.temp.min.toString() + "°"
        forecastDate.text = transformDate(data.date).toString()  //data.date.toString()
        forecastSunrise.text = "Sunrise: " + transformTime(data.sunrise).toString()
        forecastSunset.text = "Sunset: " + transformTime(data.sunset).toString()
        //forecastPressure.text = data.pressure.toString()
        //forecastHumidity.text = data.humidity.toString()
    }

    fun transformDate(timeLong : Long) : String{
        val sdf = SimpleDateFormat("MMM dd", Locale.getDefault())

        TimeZone.setDefault(TimeZone.getTimeZone("UTC+0"))
        val tz = TimeZone.getDefault()
        val now = Date()
        val offsetFromUtc = tz.getOffset(now.time)

        return sdf.format(timeLong + offsetFromUtc)
    }

    fun transformTime(timeLong: Long): String {
        val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())

        TimeZone.setDefault(TimeZone.getTimeZone("UTC+0"))
        val tz = TimeZone.getDefault()
        val now = Date()
        val offsetFromUtc = tz.getOffset(now.time)

        return sdf.format(timeLong + offsetFromUtc)
    }

}
*/
