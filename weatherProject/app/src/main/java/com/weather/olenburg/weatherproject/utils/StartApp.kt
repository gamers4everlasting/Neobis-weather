package com.weather.olenburg.weatherproject.utils

import android.app.Application

class StartApp : Application() {
    companion object {
        lateinit var INSTANCE: StartApp
        lateinit var postService: ForumService
        lateinit var weatherService: ForumService
    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
        postService = Network.initService(Conts.BASE_URL, this)
      //  weatherService = Network.initService2(Conts.BASE_WEATHER_URL, this)

    }

}