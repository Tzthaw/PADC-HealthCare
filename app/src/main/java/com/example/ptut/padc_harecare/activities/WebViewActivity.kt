package com.example.ptut.padc_harecare.activities

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import com.example.ptut.padc_harecare.R
import kotlinx.android.synthetic.main.activity_webview.*

@SuppressLint("Registered")
class WebViewActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_URL = "extra.url"
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val url = intent.getStringExtra(EXTRA_URL)
        webView.webViewClient = WebViewClient()
        toolbarTitle.text = url.toString()

        setSupportActionBar(toolbar)

        val upArrow: Drawable = resources.getDrawable(R.drawable.ic_arrow_back)
        upArrow.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)

        supportActionBar!!.setHomeAsUpIndicator(upArrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        webView.loadUrl(url)
    }
}
