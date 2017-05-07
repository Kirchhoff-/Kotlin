package com.example.kirchhoff.kotlin.domain.datasource

import com.example.kirchhoff.kotlin.domain.model.ForecastList

/**
 * @author Kirchhoff-
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}