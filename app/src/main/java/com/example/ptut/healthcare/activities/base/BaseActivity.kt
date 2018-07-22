package com.example.ptut.healthcare.activities.base

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.content_item.*

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), Observer<String> {

    override fun onChanged(t: String?) {
        displayMessage(t)
    }
     private fun displayMessage(t: String?) {
         Toast.makeText(this,t, Toast.LENGTH_SHORT).show()
    }
}