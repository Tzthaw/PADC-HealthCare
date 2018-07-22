package com.example.ptut.healthcare.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.ptut.healthcare.model.base.BaseModel
import com.example.ptut.healthcare.network.response.GetHealthCareInfoResponse
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
import com.example.ptut.healthcare.utils.AppConstants
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HealthCareInfoModel private constructor(context: Context) : BaseModel(context) {
    companion object {
        private var INSTANCE: HealthCareInfoModel? = null
        fun getInstance(): HealthCareInfoModel {
            if (INSTANCE == null) {
                throw RuntimeException("HealthCareInfoModel is being invoked before initializing.")
            }
            val i = INSTANCE
            return i!!
        }
        fun initNewsAppModel(context: Context) {
            INSTANCE = HealthCareInfoModel(context)
        }
    }
    init {
    }
    fun getHealthCareInfoItem(mHealthLD: MutableLiveData<List<HealthcareInfoItem>>, errorLD: MutableLiveData<String>) {
        mTheApi.getHealthCareInfo(AppConstants.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthCareInfoResponse> {
                    override fun onNext(getHealthCarInfoResponse: GetHealthCareInfoResponse) {
                        if(getHealthCarInfoResponse != null && getHealthCarInfoResponse.healthcareInfo!!.isNotEmpty()){
                            saveInfoData(getHealthCarInfoResponse.healthcareInfo!!)
                            mHealthLD.value = getHealthCarInfoResponse.healthcareInfo
                        }else{
                            errorLD.value="Null from Response"
                        }
                    }
                    override fun onSubscribe(d: Disposable) {}
                    override fun onError(e: Throwable) {
                        errorLD.value = e.message
                    }
                    override fun onComplete() {}
                })
    }

    fun getAllInfo():List<HealthcareInfoItem>{
        return mTheDB.healthcareInfo().getAllInfo()
    }

    fun saveInfoData(healthCareInfoList:List<HealthcareInfoItem>){
        mTheDB.healthcareInfo().insertAll(healthCareInfoList)
    }
}