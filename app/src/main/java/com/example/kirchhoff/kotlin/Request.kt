package com.example.kirchhoff.kotlin

import android.util.Log
import java.net.URL

/**
 * @author Kirchhoff-
 */


class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}