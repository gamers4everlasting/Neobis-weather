package com.weather.olenburg.weatherproject.ui.comment

import com.weather.olenburg.weatherproject.model.Comment

interface CommentContract {
    interface View {
        fun onSuccess(data: ArrayList<Comment>)
        fun onError(m: String)
    }

    interface presenter {
        fun getComment(id: Int)
    }

}