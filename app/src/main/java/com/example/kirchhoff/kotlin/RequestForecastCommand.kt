package com.example.kirchhoff.kotlin

import com.example.kirchhoff.kotlin.domain.ForecastDataMapper
import com.example.kirchhoff.kotlin.domain.ForecastList

/**
 * @author Kirchhoff-
 */
class RequestForecastCommand(val zipCode: String) :
        Command<ForecastList> {


    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())
    }

}