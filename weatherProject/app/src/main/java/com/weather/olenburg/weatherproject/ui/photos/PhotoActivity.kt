package com.weather.olenburg.weatherproject.ui.photos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.weather.olenburg.weatherproject.R
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        val  picUrl = intent.getStringExtra(getString(R.string.album_pic))
        Glide.with(applicationContext).load(picUrl).into(image)
    }
}
