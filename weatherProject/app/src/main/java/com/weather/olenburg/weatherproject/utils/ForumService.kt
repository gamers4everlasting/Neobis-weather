package com.weather.olenburg.weatherproject.utils

import com.weather.olenburg.weatherproject.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ForumService {

    @GET("posts")
    fun getPost() : Call<ArrayList<Posts>>

    @GET("/comments?")
    fun getComment(@Query("postId") id: Int) : Call<ArrayList<Comment>>

    @GET("weather?")
    fun  getWeather(@Query("id") id: Int, @Query("appid") key: String) : Call<Weather>

    @GET("albums")
    fun getAlbums() : Call<ArrayList<Album>>

    @GET ("/photos?")
    fun getPhotos(@Query("albumId") id: Int) : Call<ArrayList<Album>>
    @GET ("/photos?albums")
    fun getPhotoAlbums() : Call<ArrayList<Album>>
}
