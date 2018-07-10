package com.example.ptut.padc_harecare.model

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.example.ptut.padc_harecare.model.base.BaseModel
import com.example.ptut.padc_harecare.network.response.GetHealthCareInfoResponse
import com.example.ptut.padc_harecare.persistence.entities.HealthcareInfoItem
import com.example.ptut.padc_harecare.utils.AppConstants
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rx.Observable

class HealthCareInfoModel private constructor(context: Context):BaseModel(context){
    companion object {
        private var INSTANCE:HealthCareInfoModel?=null
        fun getInstance():HealthCareInfoModel{
            if(INSTANCE==null){
                throw RuntimeException("HealthCareInfoModel is being invoked before initializing.")
            }
            val i= INSTANCE
            return i!!
        }
        fun initNewsAppModel(context : Context) {
            INSTANCE = HealthCareInfoModel(context)
        }
    }
    init {

    }

    fun getHealthCareInfoItem( mHealthLD:MutableLiveData<List<HealthcareInfoItem>>,errorLD:MutableLiveData<String>){
        mTheApi.getHealthCareInfo(AppConstants.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthCareInfoResponse> {
                    override fun onNext(getHealthCarInfoResponse: GetHealthCareInfoResponse) {
                        Log.e("HealthcareItem",getHealthCarInfoResponse.healthcareInfo.toString())
                        var id=mTheDB.healthcareInfo().insertAll(getHealthCarInfoResponse.healthcareInfo!!)
                        Log.e("Id :","Insert id ${id.toString()}")
                        mHealthLD.value=getHealthCarInfoResponse.healthcareInfo

                    }
                    override fun onSubscribe(d: Disposable) {
                    }
                    override fun onError(e: Throwable) {
                        errorLD.value=e.message
                    }
                    override fun onComplete() {
                    }
                })
    }


}