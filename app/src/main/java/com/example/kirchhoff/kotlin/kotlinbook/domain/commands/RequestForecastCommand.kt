package com.example.kirchhoff.kotlin.kotlinbook.domain.commands

import com.example.kirchhoff.kotlin.kotlinbook.domain.datasource.ForecastProvider
import com.example.kirchhoff.kotlin.kotlinbook.domain.model.ForecastList

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

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}