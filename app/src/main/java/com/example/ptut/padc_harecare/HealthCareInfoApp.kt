package com.example.ptut.padc_harecare

import android.app.Application
import android.arch.persistence.room.Room
import com.example.ptut.padc_harecare.model.HealthCareInfoModel
import com.example.ptut.padc_harecare.persistence.AppDatabase

class HealthCareInfoApp:Application() {

    override fun onCreate() {
        super.onCreate()
        HealthCareInfoModel.initNewsAppModel(this)
    }


}