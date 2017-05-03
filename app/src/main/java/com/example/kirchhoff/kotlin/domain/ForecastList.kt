package com.example.kirchhoff.kotlin.domain

/**
 * @author Kirchhoff-
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {

    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}