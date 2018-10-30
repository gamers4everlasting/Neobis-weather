package com.weather.olenburg.weatherproject.utils

import com.weather.olenburg.weatherproject.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ForumService2 {

    @GET("weather?")
    fun  getWeather(@Query("id") id: Int, @Query("appid") key: String) : Call<WeatherObject>

}
