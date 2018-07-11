package com.example.ptut.padc_harecare.activities.base

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

open class BaseActivity : AppCompatActivity(), Observer<String> {
    override fun onChanged(t: String?) {
        displayErrorMessage(t)
    }
    private fun displayErrorMessage(s: String?) {

    }

}