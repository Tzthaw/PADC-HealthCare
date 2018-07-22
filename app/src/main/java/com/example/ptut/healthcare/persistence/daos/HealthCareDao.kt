package com.example.ptut.healthcare.persistence.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.ptut.healthcare.persistence.daos.base.BaseDao
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
@Dao
interface HealthCareDao :BaseDao<HealthcareInfoItem>{
    @Query("SELECT * FROM healthInfo")
    fun getAllInfo():List<HealthcareInfoItem>
}