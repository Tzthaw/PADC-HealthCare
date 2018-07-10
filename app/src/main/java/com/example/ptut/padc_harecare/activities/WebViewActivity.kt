package com.example.ptut.padc_harecare.activities

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.webkit.WebViewClient
import com.example.ptut.padc_harecare.R
import kotlinx.android.synthetic.main.activity_webview.*

@SuppressLint("Registered")
class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val url = intent.getStringExtra(EXTRA_URL)
        webView.webViewClient = WebViewClient()

        toolbar.title = ""
        setSupportActionBar(toolbar)

        val upArrow: Drawable = getResources().getDrawable(R.drawable.ic_arrow_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        supportActionBar!!.setHomeAsUpIndicator(upArrow);

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        webView.loadUrl(url)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
        // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_URL = "extra.url"
    }
}
