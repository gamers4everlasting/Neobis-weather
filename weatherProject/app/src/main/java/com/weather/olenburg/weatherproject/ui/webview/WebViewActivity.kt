package com.weather.olenburg.weatherproject.ui.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.weather.olenburg.weatherproject.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webview.loadUrl("http://www.o.kg/")
    }
}
