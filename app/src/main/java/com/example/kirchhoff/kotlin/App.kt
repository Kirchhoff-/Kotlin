package com.example.kirchhoff.kotlin

import android.app.Application

/**
 * @author Kirchhoff-
 */
class App : Application() {


    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}