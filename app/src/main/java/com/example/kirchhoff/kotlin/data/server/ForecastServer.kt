package com.example.kirchhoff.kotlin.data.server

import com.example.kirchhoff.kotlin.data.db.ForecastDb
import com.example.kirchhoff.kotlin.domain.datasource.ForecastDataSource
import com.example.kirchhoff.kotlin.domain.model.ForecastList
import java.lang.UnsupportedOperationException

/**
 * @author Kirchhoff-
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {


    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }


    override fun requestDayForecast(id: Long) = throw  UnsupportedOperationException()
}