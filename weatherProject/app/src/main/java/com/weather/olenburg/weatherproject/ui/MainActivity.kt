package com.weather.olenburg.weatherproject.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.weather.olenburg.weatherproject.R
import com.weather.olenburg.weatherproject.ui.albums.AlbumFragment
import com.weather.olenburg.weatherproject.ui.posts.PostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.post -> {
                addFrag(PostFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.album -> {
                addFrag(AlbumFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun addFrag(frag: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, frag)
                .commit()
    }
}
