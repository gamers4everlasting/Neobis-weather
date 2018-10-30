package com.weather.olenburg.weatherproject.utils

import com.weather.olenburg.weatherproject.utils.Conts.Companion.BASE_WEATHER_URL
import retrofit2.Retrofit

class StartApp2 {

    companion object {


        private var app: StartApp2? = null
        private var retrofit: Retrofit? = null

        fun getApp(): StartApp2 {
            if (app == null) {
                app = StartApp2()
            }
            return app!!
        }

        fun getClient() : ForumService {
            return Retrofit.Builder().baseUrl(BASE_WEATHER_URL).build().create(ForumService::class.java)
        }

    }
}