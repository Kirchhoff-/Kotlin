package com.example.kirchhoff.kotlin.kotlinbook.domain.commands

import com.example.kirchhoff.kotlin.kotlinbook.domain.datasource.ForecastProvider
import com.example.kirchhoff.kotlin.kotlinbook.domain.model.Forecast

/**
 * @author Kirchhoff-
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}