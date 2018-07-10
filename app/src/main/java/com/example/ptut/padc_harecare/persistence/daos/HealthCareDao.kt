package com.example.ptut.padc_harecare.persistence.daos

import android.arch.persistence.room.Dao
import com.example.ptut.padc_harecare.persistence.daos.base.BaseDao
import com.example.ptut.padc_harecare.persistence.entities.HealthcareInfoItem
@Dao
interface HealthCareDao :BaseDao<HealthcareInfoItem>{

}