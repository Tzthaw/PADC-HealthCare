package com.example.ptut.padc_harecare.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ptut.padc_harecare.persistence.daos.HealthCareDao
import com.example.ptut.padc_harecare.persistence.entities.HealthcareInfoItem

@Database(entities = [(HealthcareInfoItem::class)], version =1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun healthcareInfo(): HealthCareDao
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSTANCE
            return i!!
        }
    }
}