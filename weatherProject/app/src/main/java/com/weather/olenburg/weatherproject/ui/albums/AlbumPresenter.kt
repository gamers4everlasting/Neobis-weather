package com.weather.olenburg.weatherproject.ui.albums

import com.weather.olenburg.weatherproject.model.Album
import com.weather.olenburg.weatherproject.utils.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumPresenter(var v: AlbumContract.View): AlbumContract.Presenter {
    override fun getAlbums() {
        ApiClient.getInstance().client.getPhotoAlbums().enqueue(object : Callback<ArrayList<Album>> {
            override fun onFailure(call: Call<ArrayList<Album>>, t: Throwable) {
                    v.onError(t.localizedMessage)
            }

            override fun onResponse(call: Call<ArrayList<Album>>, response: Response<ArrayList<Album>>) {
                if(response.isSuccessful)
                {
                    v.onAlbumSuccess(response.body()!!)
                }
            }

        })
    }
}


