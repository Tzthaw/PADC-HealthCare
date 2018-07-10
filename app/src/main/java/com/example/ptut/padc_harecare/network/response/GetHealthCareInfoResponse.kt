package com.example.ptut.padc_harecare.network.response

import android.arch.persistence.room.ColumnInfo
import com.example.ptut.padc_harecare.persistence.entities.HealthcareInfoItem
import com.example.ptut.padc_harecare.network.response.base.BaseResponse
import com.google.gson.annotations.SerializedName

open class GetHealthCareInfoResponse(
        @SerializedName("healthcare-info")
        var healthcareInfo: List<HealthcareInfoItem>? = null): BaseResponse() {
}