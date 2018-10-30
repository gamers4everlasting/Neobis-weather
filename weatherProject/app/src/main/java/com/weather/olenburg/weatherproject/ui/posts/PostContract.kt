package com.weather.olenburg.weatherproject.ui.posts

import com.weather.olenburg.weatherproject.model.Posts
import com.weather.olenburg.weatherproject.model.Weather

interface PostContract {

    interface View {
        fun onPostSuccess(data: ArrayList<Posts>)
        fun onError(m: String)
        fun onWeatherSuccess(data: Weather)
    }
    interface Presenter {
        fun getPosts()
        fun getWeather(id: Int)
    }


}