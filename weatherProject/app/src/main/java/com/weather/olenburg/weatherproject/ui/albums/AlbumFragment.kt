package com.weather.olenburg.weatherproject.ui.albums

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weather.olenburg.weatherproject.R
import com.weather.olenburg.weatherproject.model.Album
import com.weather.olenburg.weatherproject.ui.photos.PhotoActivity
import kotlinx.android.synthetic.main.fragment_album.view.*
import java.util.*
import kotlin.collections.ArrayList
import android.R.attr.spacing



class AlbumFragment: Fragment(), AlbumContract.View, AlbumAdapter.aClicklistener{

    private lateinit var adapter: AlbumAdapter
    private lateinit var presenter: AlbumPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        adapter = AlbumAdapter(this)
        presenter = AlbumPresenter(this)
        view.recviewAlbum.layoutManager = GridLayoutManager(view.context,  3)
        view.recviewAlbum.adapter = adapter
        presenter.getAlbums()
    }

    override fun onAlbumListener(pic: String) {
        val  intent = Intent(context, PhotoActivity::class.java)
        intent.putExtra(getString(R.string.album_pic), pic)
        startActivity(intent)
    }

    override fun onAlbumSuccess(data: ArrayList<Album>) {
        val aData: ArrayList<Album> = ArrayList(10)
        for(i in 0..10) aData.add(data[(0..100).random()])
        adapter.setPhotoData(aData)
    }


    override fun onError(m: String) {

    }



    fun IntRange.random() =
            Random().nextInt((endInclusive + 1) - start) +  start
}