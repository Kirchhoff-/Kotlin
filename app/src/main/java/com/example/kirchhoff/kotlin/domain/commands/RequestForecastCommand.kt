package com.example.kirchhoff.kotlin.domain.commands

import com.example.kirchhoff.kotlin.domain.datasource.ForecastProvider
import com.example.kirchhoff.kotlin.domain.model.ForecastList

/**
 * @author Kirchhoff-
 */
class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}