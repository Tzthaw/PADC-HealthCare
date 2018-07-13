package com.example.ptut.healthcare

import android.app.Application
import com.example.ptut.healthcare.model.HealthCareInfoModel

class HealthCareInfoApp:Application() {
    override fun onCreate() {
        super.onCreate()
        HealthCareInfoModel.initNewsAppModel(this@HealthCareInfoApp)
    }
}