package com.example.ptut.padc_harecare.activities.base

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(), Observer<String> {
    override fun onChanged(t: String?) {
    }

}