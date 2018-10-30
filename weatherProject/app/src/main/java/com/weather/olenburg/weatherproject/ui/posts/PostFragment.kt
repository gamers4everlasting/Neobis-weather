package com.weather.olenburg.weatherproject.ui.posts

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.olenburg.weatherproject.R
import com.weather.olenburg.weatherproject.model.Posts
import com.weather.olenburg.weatherproject.model.Weather
import com.weather.olenburg.weatherproject.ui.comment.CommentActivity
import com.weather.olenburg.weatherproject.ui.webview.WebViewActivity
import kotlinx.android.synthetic.main.fragment_post.view.*
import java.util.*
import kotlin.collections.ArrayList
import android.support.v7.widget.DividerItemDecoration



class PostFragment : Fragment(), PostContract.View, PostAdapter.mClicklistener {
    override fun onWeatherSuccess(data: Weather) {
        weatherData = data
        genData.add(data)
        adapter.setGeneralData(genData)
    }

    private lateinit var presenter: PostPresenter
    private lateinit var adapter: PostAdapter
    private lateinit var weatherData: Weather

    private var genData: ArrayList<Any> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        adapter = PostAdapter(this)
        presenter = PostPresenter(this)
        view.recviewPost.layoutManager = LinearLayoutManager(view.context)
        val decoration = DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL)
        view.recviewPost.addItemDecoration(decoration);

        view.recviewPost.adapter = adapter
        presenter.getPosts()
        presenter.getWeather(1528334)
    }

    override fun onPostListener(data: Posts?) {
        if (data == null) {
            val  intent = Intent(context, WebViewActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra(getString(R.string.comment_data), data)
            startActivity(intent)
        }
    }

    override fun onPostSuccess(data: ArrayList<Posts>) {
        //val mData: ArrayList<Posts> = ArrayList(10)
        for (i in 0..9) {
            genData.add(data[(0..99).random()])
        }
       // adapter.setGeneralData(arrayListOf(mData))
    }

    override fun onError(m: String) {

    }

    fun IntRange.random() =
            Random().nextInt((endInclusive + 1) - start) +  start


}