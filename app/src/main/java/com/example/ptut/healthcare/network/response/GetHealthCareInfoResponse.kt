package com.example.ptut.healthcare.network.response

import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
import com.example.ptut.healthcare.network.response.base.BaseResponse
import com.google.gson.annotations.SerializedName

open class GetHealthCareInfoResponse(
        @SerializedName("healthcare-info")
        var healthcareInfo: List<HealthcareInfoItem>? = null): BaseResponse() {
}