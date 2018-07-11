package com.example.ptut.padc_harecare

import android.app.Application
import com.example.ptut.padc_harecare.model.HealthCareInfoModel

class HealthCareInfoApp:Application() {
    override fun onCreate() {
        super.onCreate()
        HealthCareInfoModel.initNewsAppModel(this@HealthCareInfoApp)
    }
}