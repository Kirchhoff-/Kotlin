package com.example.kirchhoff.kotlin.domain

/**
 * @author Kirchhoff-
 */
data class ForecastList(val city: String, val country: String,
                        val dilyForecast: List<Forecast>)