package com.weather.olenburg.weatherproject.ui.albums

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.weather.olenburg.weatherproject.model.Album
import kotlinx.android.synthetic.main.cell_album.view.*

class AlbumAdapter(var listener: aClicklistener) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private var data: ArrayList<Album>? = null


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.cell_album, p0, false))
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.album_text.text = data!![position].title
        Glide.with(holder.itemView.context).load(data!![position].thumbnailUrl).into(holder.itemView.album_icon)
        holder.itemView.setOnClickListener {
            listener.onAlbumListener(data!![position].url)
        }
    }

    fun setPhotoData(aData: ArrayList<Album>) {
        data  = aData
        notifyDataSetChanged()
    }


    class ViewHolder(v: View): RecyclerView.ViewHolder(v)

    interface aClicklistener {
        fun onAlbumListener(pic: String)
    }
}