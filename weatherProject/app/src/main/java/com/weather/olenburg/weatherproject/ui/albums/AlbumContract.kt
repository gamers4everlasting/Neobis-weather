package com.weather.olenburg.weatherproject.ui.albums

import com.weather.olenburg.weatherproject.model.Album


interface AlbumContract {
    interface View{
        fun onAlbumSuccess(data: ArrayList<Album>)
        fun onError(m: String)
    }

    interface Presenter {
        fun getAlbums()
    }
}