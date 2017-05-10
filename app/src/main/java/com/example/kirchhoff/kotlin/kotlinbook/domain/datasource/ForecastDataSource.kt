package com.example.kirchhoff.kotlin.kotlinbook.domain.datasource

import com.example.kirchhoff.kotlin.kotlinbook.domain.model.Forecast
import com.example.kirchhoff.kotlin.kotlinbook.domain.model.ForecastList

/**
 * @author Kirchhoff-
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}