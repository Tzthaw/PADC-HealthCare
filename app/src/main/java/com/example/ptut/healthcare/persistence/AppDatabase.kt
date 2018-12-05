package com.example.ptut.healthcare.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ptut.healthcare.persistence.daos.HealthCareDao
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
import com.example.ptut.healthcare.utils.AppConstants

@Database(entities = [(HealthcareInfoItem::class)], version =1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun healthcareInfo(): HealthCareDao
    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                return Room.databaseBuilder(context, AppDatabase::class.java,AppConstants.DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSTANCE
            return i!!
        }
    }
}