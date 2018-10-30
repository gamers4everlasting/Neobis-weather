package com.weather.olenburg.weatherproject.ui.posts

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.olenburg.weatherproject.R
import com.weather.olenburg.weatherproject.model.Posts
import com.weather.olenburg.weatherproject.model.Weather
import kotlinx.android.synthetic.main.cell_post.view.*
import kotlinx.android.synthetic.main.cell_weather.view.*
import java.util.*
import kotlin.collections.ArrayList

class PostAdapter(var listener: mClicklistener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var genData: ArrayList<Any> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        if (type == 0) {
            Log.e("_____type = 0 ", "this")
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.cell_post, parent, false)
            return PostViewHolder(v)
        } else {
            Log.e("_____type = 1 ", "that")
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.cell_weather, parent, false)
            return WeatherViewHolder(v)
        }
    }

    override fun getItemCount(): Int {
        return genData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (genData.isNotEmpty()) {
            if (holder.itemViewType == 0) {
                Log.e("_____type = 0 ", "bind")
                val  postViewHolder: PostViewHolder = holder as PostViewHolder
                postViewHolder.bindPost(holder.itemView, genData[position] as Posts)
                postViewHolder.itemView.setOnClickListener {
                    listener.onPostListener(genData[position] as Posts)
                }
            } else {
                var weatherViewHolder: WeatherViewHolder = holder as WeatherViewHolder
                weatherViewHolder.bindWeather(holder.itemView, genData[position] as Weather)
                weatherViewHolder.itemView.setOnClickListener {
                    listener.onPostListener(null)
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        Log.e("_____itemViewType ", genData[position].toString())

        if (genData[position] is Posts) {

            return 0
        } else {
            return 1
        }
    }


    interface mClicklistener {
        fun onPostListener(data: Posts?)
    }

    class PostViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindPost(v: View, data: Posts) {
            v.title.text = data.title
            v.body.text = data.body
            v.post_icon.setBackgroundColor(getRandColor())
            v.post_text.text = data.title[0].toString()
        }

        private fun getRandColor(): Int {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            return color
        }

    }

    class WeatherViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindWeather(v: View, data: Weather) {
            v.temp.text = data.temp.toString()
        }
    }

    fun setGeneralData(genData: ArrayList<Any>) {
        val position = genData.size

        this.genData.addAll(genData)
        Log.e("_________genddata", genData[0].toString())
        this.genData.shuffle()
        notifyDataSetChanged()
    }
}