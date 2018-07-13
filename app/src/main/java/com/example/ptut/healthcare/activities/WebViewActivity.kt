package com.example.ptut.healthcare.activities

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import com.example.ptut.healthcare.R
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
        setSupportActionBar(toolbar)

        val upArrow:Drawable= ContextCompat.getDrawable(this@WebViewActivity, R.drawable.ic_arrow_back)!!
        upArrow.setColorFilter( ResourcesCompat.getColor(resources, R.color.white, null), PorterDuff.Mode.SRC_ATOP)

        supportActionBar!!.setHomeAsUpIndicator(upArrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this@WebViewActivity.finish()
    }
}
