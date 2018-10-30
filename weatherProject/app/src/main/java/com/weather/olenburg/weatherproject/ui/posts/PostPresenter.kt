package com.weather.olenburg.weatherproject.ui.posts

import com.weather.olenburg.weatherproject.model.Posts
import com.weather.olenburg.weatherproject.model.Weather
import com.weather.olenburg.weatherproject.model.WeatherObject
import com.weather.olenburg.weatherproject.utils.ApiClient
import com.weather.olenburg.weatherproject.utils.Conts.Companion.API_KEY
import com.weather.olenburg.weatherproject.utils.StartApp
import com.weather.olenburg.weatherproject.utils.StartApp2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostPresenter(val v: PostContract.View) : PostContract.Presenter {
    override fun getWeather(id: Int) {
        ApiClient.getInstance().client2.getWeather(id, API_KEY).enqueue(object : Callback<WeatherObject> {
            override fun onFailure(call: Call<WeatherObject>, t: Throwable) {

            }

            override fun onResponse(call: Call<WeatherObject>, response: Response<WeatherObject>) {
                if (response.isSuccessful) {
                    v.onWeatherSuccess(response.body()!!.main)
                }
            }

        })
    }

    override fun getPosts() {
        ApiClient.getInstance().client.getPost().enqueue(object : Callback<ArrayList<Posts>> {
            override fun onFailure(call: Call<ArrayList<Posts>>, t: Throwable) {
                v.onError(t.localizedMessage)
            }

            override fun onResponse(call: Call<ArrayList<Posts>>, response: Response<ArrayList<Posts>>) {
                if (response.isSuccessful)
                    v.onPostSuccess(response.body()!!)
                else
                    v.onError(response.message())

            }

        })

    }
}