package com.example.kirchhoff.kotlin.domain

/**
 * @author Kirchhoff-
 */
data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {

    operator fun get(position: Int) = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}