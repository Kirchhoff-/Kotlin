package com.example.kirchhoff.kotlin.db

import com.example.kirchhoff.kotlin.domain.ForecastList
import com.example.kirchhoff.kotlin.util.clear
import com.example.kirchhoff.kotlin.util.parseList
import com.example.kirchhoff.kotlin.util.parseOpt
import com.example.kirchhoff.kotlin.util.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * @author Kirchhoff-
 */
class ForecastDb(
        val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
        val dataMapper: DataMapper = DataMapper()) {


    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ?" +
                "AND ${DayForecastTable.DATE} > ?"

        val dailyForecast = select(DayForecastTable.NAME)
                .where(dailyRequest, "id" to zipCode, "date" to date)
                .parseList { DayForecast(HashMap(it)) }


        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }


        if (city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach {
                insert(DayForecastTable.NAME, *it.map.toVarargArray())
            }
        }
    }
}