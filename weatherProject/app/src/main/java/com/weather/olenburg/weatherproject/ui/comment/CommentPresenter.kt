package com.weather.olenburg.weatherproject.ui.comment

import com.weather.olenburg.weatherproject.model.Comment
import com.weather.olenburg.weatherproject.utils.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentPresenter(var view: CommentContract.View) : CommentContract.presenter {
    override fun getComment(id: Int) {
        ApiClient.getInstance().client.getComment(id).enqueue(object : Callback<ArrayList<Comment>> {
            override fun onFailure(call: Call<ArrayList<Comment>>, t: Throwable) {
                view.onError(t.message.toString())
            }

            override fun onResponse(call: Call<ArrayList<Comment>>, response: Response<ArrayList<Comment>>) {
                if (response.isSuccessful) {
                    view.onSuccess(response.body()!!)
                }
            }

        })
    }
}