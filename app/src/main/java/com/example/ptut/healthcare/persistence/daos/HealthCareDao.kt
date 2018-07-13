package com.example.ptut.healthcare.persistence.daos

import android.arch.persistence.room.Dao
import com.example.ptut.healthcare.persistence.daos.base.BaseDao
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
@Dao
interface HealthCareDao :BaseDao<HealthcareInfoItem>{
}