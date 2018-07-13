package com.example.ptut.healthcare.network

import com.example.ptut.healthcare.network.response.GetHealthCareInfoResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HealthCareService {
    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun getHealthCareInfo(@Field("access_token") access_token: String): Observable<GetHealthCareInfoResponse>

}