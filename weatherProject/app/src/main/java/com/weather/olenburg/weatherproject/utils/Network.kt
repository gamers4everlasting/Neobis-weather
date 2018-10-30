package com.weather.olenburg.weatherproject.utils

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object {


        fun initService(baseURL: String, context: Context): ForumService {
            return Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ForumService::class.java)
        }
    }
}