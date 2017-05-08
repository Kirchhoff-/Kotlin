package com.example.kirchhoff.kotlin.domain.commands

import com.example.kirchhoff.kotlin.domain.datasource.ForecastProvider
import com.example.kirchhoff.kotlin.domain.model.Forecast

/**
 * @author Kirchhoff-
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}